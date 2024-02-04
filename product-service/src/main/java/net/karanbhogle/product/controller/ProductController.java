package net.karanbhogle.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.karanbhogle.product.dto.ProductDTO;
import net.karanbhogle.product.service.ProductService;

@RestController
@RequestMapping("/products/v1")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello from PRODUCT CONTROLLER";
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> registerProduct(@RequestBody ProductDTO dto) {
		ProductDTO response = service.registerProduct(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> fetchAllProducts() {
		List<ProductDTO> response = service.fetchAllProducts();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/category/{cat}")
	public ResponseEntity<List<ProductDTO>> fetchAllProducts(@PathVariable("cat") String category) {
		List<ProductDTO> response = service.fetchProductOfCategory(category);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
