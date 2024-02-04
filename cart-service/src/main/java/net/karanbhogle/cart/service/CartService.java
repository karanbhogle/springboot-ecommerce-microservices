package net.karanbhogle.cart.service;

import net.karanbhogle.cart.dto.CartDTO;

public interface CartService {
	public CartDTO getCartByUser(String userId);

	CartDTO saveToCart(CartDTO dto);
}
