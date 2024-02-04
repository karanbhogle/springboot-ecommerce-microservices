package net.karanbhogle.order.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.order.entity.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {
	Cart findByUserId(String id);

	void deleteByUserId(String userId);
}
