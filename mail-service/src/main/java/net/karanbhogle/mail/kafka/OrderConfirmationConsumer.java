package net.karanbhogle.mail.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.karanbhogle.mail.utils.StringParser;

@Service
public class OrderConfirmationConsumer {
	@KafkaListener(topics = "order-confirmation-events", groupId = "email-notification-group")
    public void listenToOrderConfirmationEvents(String orderEvent) {
        String[] orderDetails = StringParser.getOrderDetails(orderEvent);

        // Implement logic to send email notification based on the order event
        // You can use JavaMailSender or any email sending library here
        
        // For now, I've just printed values
     // Print the extracted values
        System.out.println("OrderId: " + orderDetails[0]);
        System.out.println("UserId: " + orderDetails[1]);
        System.out.println("UserEmail: " + orderDetails[2]);
    }
}
