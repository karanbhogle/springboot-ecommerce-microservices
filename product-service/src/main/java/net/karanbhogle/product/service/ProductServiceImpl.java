package net.karanbhogle.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.karanbhogle.product.converter.ProductConverter;
import net.karanbhogle.product.dto.ProductDTO;
import net.karanbhogle.product.entity.Product;
import net.karanbhogle.product.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public ProductDTO registerProduct(ProductDTO dto) {
		Product pe = ProductConverter.convertProductDTOtoEntity(dto);
		pe = repository.save(pe);
		return ProductConverter.convertProductEntitytoDTO(pe);
	}

	@Override
	@Cacheable(value = "products", key = "'allProducts'")
	public List<ProductDTO> fetchAllProducts() {
		List<Product> productList = repository.findAll();
		List<ProductDTO> responseList = new ArrayList<>();
		
		for(Product pr: productList) {
			responseList.add(ProductConverter.convertProductEntitytoDTO(pr));
		}
		return responseList;
	}

	@Override
	@Cacheable(value = "products", key = "#category")
	public List<ProductDTO> fetchProductOfCategory(String category) {
		List<Product> productList = repository.findByCategory(category);
		List<ProductDTO> responseList = new ArrayList<>();
		
		for(Product pr: productList) {
			responseList.add(ProductConverter.convertProductEntitytoDTO(pr));
		}
		return responseList;
	}

}
