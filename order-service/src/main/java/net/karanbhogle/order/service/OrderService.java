package net.karanbhogle.order.service;

import net.karanbhogle.order.dto.OrderDTO;

public interface OrderService {

	public OrderDTO createOrderFromCart(String userId);
	
}
