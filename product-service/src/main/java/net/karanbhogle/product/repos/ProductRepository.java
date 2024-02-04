package net.karanbhogle.product.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.product.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(String category);

}
