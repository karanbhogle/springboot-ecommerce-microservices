package net.karanbhogle.order.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.karanbhogle.order.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
