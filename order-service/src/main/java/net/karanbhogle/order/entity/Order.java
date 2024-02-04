package net.karanbhogle.order.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	private String id;
	
	private String userId;
	
	private List<CartProduct> cartList;
}
