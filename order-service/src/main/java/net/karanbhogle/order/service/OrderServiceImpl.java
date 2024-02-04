package net.karanbhogle.order.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import net.karanbhogle.order.converter.OrderConverter;
import net.karanbhogle.order.dto.OrderDTO;
import net.karanbhogle.order.entity.Cart;
import net.karanbhogle.order.entity.CartProduct;
import net.karanbhogle.order.entity.Order;
import net.karanbhogle.order.entity.Product;
import net.karanbhogle.order.entity.User;
import net.karanbhogle.order.repos.CartRepository;
import net.karanbhogle.order.repos.OrderRepository;
import net.karanbhogle.order.repos.ProductRepository;
import net.karanbhogle.order.repos.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public OrderDTO createOrderFromCart(String userId) {
		Cart foundCart = cartRepo.findByUserId(userId);
		if(foundCart == null) {
			return null;
		}
		
		Optional<User> foundUserOptional = userRepo.findById(userId);
        if (foundUserOptional.isEmpty()) {
            return null; // or handle the case when the user is not found
        }
        
		User foundUser = foundUserOptional.get();
		
		List<CartProduct> cartItemList = new ArrayList<>();
		
		for(CartProduct cartProduct: foundCart.getCartProducts()) {
			Optional<Product> optProd = prodRepo.findById(cartProduct.getProductId());
			
			if(optProd.isPresent()) {
				Product foundProd = optProd.get();
				cartProduct.setPrice(foundProd.getPrice());
				cartProduct.setName(foundProd.getName());
				cartProduct.setCategory(foundProd.getCategory());
				cartItemList.add(cartProduct);
			}
		}
		foundCart.setCartProducts(cartItemList);
		
		// register order for the user
		Order oe = new Order();
		oe.setCartList(cartItemList);
		oe.setUserId(userId);
		
		// delete user's cart from the database
		cartRepo.deleteByUserId(userId);
		
		Order savedOrder = orderRepo.save(oe);
		
		// Publish event to Kafka to send mail about confirmed order
        String orderEvent = 
        		"OrderId?" + savedOrder.getId() + ":::"
        		+ "UserId?" + foundUser.getId() + ":::"
        		+ "UserEmail?" + foundUser.getEmail();
        kafkaTemplate.send("order-confirmation-events", orderEvent);
        
		return OrderConverter.convertOrderEntitytoDTO(savedOrder);
		
	}

    
}
