package net.karanbhogle.cart.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.cart.entity.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {
	Cart findByUserId(String id);
}
