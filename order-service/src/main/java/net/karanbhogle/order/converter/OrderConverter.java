package net.karanbhogle.order.converter;

import net.karanbhogle.order.dto.OrderDTO;
import net.karanbhogle.order.entity.Order;

public class OrderConverter {
	public static OrderDTO convertOrderEntitytoDTO(Order oe) {
		OrderDTO oDTO = new OrderDTO();
		oDTO.setId(oe.getId());
		oDTO.setUserId(oe.getUserId());
		oDTO.setCartList(oe.getCartList());
		return oDTO;
	}
	
	public static Order converOrderDTOtoEntity(OrderDTO oDTO) {
		Order oe = new Order();
		oe.setId(oDTO.getId());
		oe.setUserId(oDTO.getUserId());
		oe.setCartList(oDTO.getCartList());
		return oe;
	}
}
