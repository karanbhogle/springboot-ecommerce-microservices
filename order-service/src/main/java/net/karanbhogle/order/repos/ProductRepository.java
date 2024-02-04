package net.karanbhogle.order.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.order.entity.Product;


public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(String category);
	
	Optional<Product> findById(String id);
}

