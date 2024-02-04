
# Ecommerce Project using Spring Boot, Redis, Kong, Apache Kafka, and MongoDB

This is a multi-module microservice Spring Boot project. Used Redis for caching product-service data, Kong for API Gateway, Apache Kafka for notifying mail-service about the confirmed order and MongoDB for storing data.

## The Architecture
![Alt Text](https://miro.medium.com/v2/resize:fit:828/format:webp/1*epet8HYZIJ9M4fb_3HV1Hg.jpeg)

## Setup and Installation
1. Install WSL2 Ubuntu, if you're using Windows.
2. Open the Ubuntu Terminal and [install Kong](https://konghq.com/install) and [Redis Server](https://redis.io/docs/install/install-redis/install-redis-on-windows/).
3. Run Kong and Redis server.
4. Run Apache Kafka and create topic named "order-confirmation-events" for notifying mail-service.
5. On Kong, you need to create Gateway Services and routes for all the endpoints of all the microservices. ![Alt Text](https://miro.medium.com/v2/resize:fit:828/format:webp/1*hPK7UjIGMCsrpZsIYOCx0g.jpeg)
6. On Kong, install Key Authentication plugin and create Consumer and it's credentials. Configure the scope as Global to allow authentic users only. Copy the key and use that key to send requests.
7. Test your APIs. Enjoy.

## Links
Medium Article - [Building beyond the Basics: Crafting Microservices with Spring Boot, Redis, Kong, Kafka, and MongoDB](https://medium.com/@karanbhogle/building-beyond-the-basics-crafting-microservices-with-spring-boot-redis-kong-kafka-and-269d25853e33)
