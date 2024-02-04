package net.karanbhogle.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.karanbhogle.order.entity.CartProduct;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private String id;
	
	private String userId;
	
	private List<CartProduct> cartList;
}
