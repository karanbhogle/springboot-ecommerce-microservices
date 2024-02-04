package net.karanbhogle.cart.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.karanbhogle.cart.converter.CartConverter;
import net.karanbhogle.cart.dto.CartDTO;
import net.karanbhogle.cart.dto.CartProductDTO;
import net.karanbhogle.cart.entity.Cart;
import net.karanbhogle.cart.repos.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repository;

    @Override
    public CartDTO saveToCart(CartDTO dto) {
        // Check if a cart already exists for the user
        Cart existingCart = repository.findByUserId(dto.getUserId());
        for(CartProductDTO cartItems: dto.getCartProducts()) {
        	cartItems.setId(UUID.randomUUID().toString());
        }

        if (existingCart == null) {
            // If the cart doesn't exist, create a new one
            Cart newCart = CartConverter.convertCartDTOtoEntity(dto);
            Cart savedCart = repository.save(newCart);
            return CartConverter.convertCartEntitytoDTO(savedCart);
        } else {
            // If the cart exists, update the items in the existing cart
            existingCart.getCartProducts().addAll(CartConverter.convertCartDTOtoEntity(dto).getCartProducts());
            Cart updatedCart = repository.save(existingCart);
            return CartConverter.convertCartEntitytoDTO(updatedCart);
        }
    }

    @Override
    public CartDTO getCartByUser(String userId) {
        // Fetch the cart of a specific user using userId
        Cart cart = repository.findByUserId(userId);
        if (cart != null) {
            return CartConverter.convertCartEntitytoDTO(cart);
        } else {
            // Return an empty cart or handle the scenario as needed
            return new CartDTO();
        }
    }
}
