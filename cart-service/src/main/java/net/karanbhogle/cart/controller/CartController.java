package net.karanbhogle.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.karanbhogle.cart.dto.CartDTO;
import net.karanbhogle.cart.service.CartService;

@RestController
@RequestMapping("/carts/v1")
public class CartController {

	@Autowired
	private CartService service;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello from CARTS CONTROLLER";
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<CartDTO> getUserCart(@PathVariable("id") String id) {
		CartDTO response = service.getCartByUser(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CartDTO> saveCart(@RequestBody CartDTO dto) {
		CartDTO response = service.saveToCart(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
