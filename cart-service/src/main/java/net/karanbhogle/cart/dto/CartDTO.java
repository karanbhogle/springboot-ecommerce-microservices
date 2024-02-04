package net.karanbhogle.cart.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	private String id;
    private String userId;
    private List<CartProductDTO> cartProducts;
}
