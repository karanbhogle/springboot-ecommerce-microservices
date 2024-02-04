package net.karanbhogle.order.repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.order.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);
	Optional<User> findById(String id);
}
