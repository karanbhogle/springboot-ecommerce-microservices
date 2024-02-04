package net.karanbhogle.order.entity;

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
    
    private String name;
    
    private String category;
    
    private Double price;

    private int quantity;
}

