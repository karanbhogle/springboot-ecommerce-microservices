package net.karanbhogle.product.converter;

import org.springframework.stereotype.Component;

import net.karanbhogle.product.dto.ProductDTO;
import net.karanbhogle.product.entity.Product;

@Component
public class ProductConverter {
	public static ProductDTO convertProductEntitytoDTO(Product pe) {
		ProductDTO dto = new ProductDTO();
		dto.setId(pe.getId());
		dto.setName(pe.getName());
		dto.setCategory(pe.getCategory());
		dto.setPrice(pe.getPrice());
		return dto;
	}
	
	public static Product convertProductDTOtoEntity(ProductDTO dto) {
		Product pe = new Product();
		pe.setId(dto.getId());
		pe.setName(dto.getName());
		pe.setCategory(dto.getCategory());
		pe.setPrice(dto.getPrice());
		return pe;
	}
}
