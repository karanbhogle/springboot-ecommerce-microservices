package net.karanbhogle.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.karanbhogle.order.dto.OrderDTO;
import net.karanbhogle.order.service.OrderService;

@RestController
@RequestMapping("/orders/v1")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello from ORDER CONTROLLER";
	}
	
	@GetMapping("/users/{id}")
    public ResponseEntity<OrderDTO> processOrder(@PathVariable("id") String userId) {
        OrderDTO response = service.createOrderFromCart(userId);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
