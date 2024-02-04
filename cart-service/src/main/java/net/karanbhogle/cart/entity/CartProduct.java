package net.karanbhogle.cart.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct {

    @Id
    private String id;

    private String productId;

    private int quantity;
}

