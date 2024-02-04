package net.karanbhogle.cart.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.karanbhogle.cart.entity.Cart;
import net.karanbhogle.cart.entity.CartProduct;
import net.karanbhogle.cart.dto.CartDTO;
import net.karanbhogle.cart.dto.CartProductDTO;

@Component
public class CartConverter {
	public static Cart convertCartDTOtoEntity(CartDTO dto) {
		Cart oe = new Cart();
		oe.setId(dto.getId());
		oe.setUserId(dto.getUserId());
		
		List<CartProduct> cartProdList = new ArrayList<>();
		
		for(CartProductDTO cartProdDTO:dto.getCartProducts()) {
			CartProduct cp = new CartProduct();
			cp.setId(cartProdDTO.getId());
			cp.setProductId(cartProdDTO.getProductId());
			cp.setQuantity(cartProdDTO.getQuantity());
			cartProdList.add(cp);
		}
		oe.setCartProducts(cartProdList);
		return oe;
	}
	
	
	public static CartDTO convertCartEntitytoDTO(Cart oe) {
		CartDTO dto = new CartDTO();
		dto.setId(oe.getId());
		dto.setUserId(oe.getUserId());
		
		List<CartProductDTO> cartProductDTOList = new ArrayList<>();
		
		for(CartProduct cpe: oe.getCartProducts()) {
			CartProductDTO cpDTO = new CartProductDTO();
			cpDTO.setId(cpe.getId());
			cpDTO.setProductId(cpe.getProductId());
			cpDTO.setQuantity(cpe.getQuantity());
			cartProductDTOList.add(cpDTO);
		}
		dto.setCartProducts(cartProductDTOList);
		return dto;
	}
	
}
