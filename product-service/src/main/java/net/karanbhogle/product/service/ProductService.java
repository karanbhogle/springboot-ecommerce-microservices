package net.karanbhogle.product.service;

import java.util.List;

import net.karanbhogle.product.dto.ProductDTO;

public interface ProductService {
	public ProductDTO registerProduct(ProductDTO dto);
	
	public List<ProductDTO> fetchAllProducts();
	
	public List<ProductDTO> fetchProductOfCategory(String Category);
}
