package net.karanbhogle.user.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.user.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);

	
	Optional<User> findById(String id);
}
