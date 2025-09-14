package mba.usp.distributed.architecture.processing_service.messaging;

import mba.usp.distributed.architecture.processing_service.dtos.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationDataPublisher {

    public static final String EXCHANGE_NAME = "notification.exchange";
    public static final String ROUTING_KEY = "notification.data";
    private final RabbitTemplate rabbitTemplate;

    public NotificationDataPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(Notification data) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY, data);
    }
}