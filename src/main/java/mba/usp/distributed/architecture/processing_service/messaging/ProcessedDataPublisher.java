package mba.usp.distributed.architecture.processing_service.messaging;

import mba.usp.distributed.architecture.processing_service.model.SensorData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcessedDataPublisher {

    public static final String EXCHANGE_NAME = "persistence.exchange";
    public static final String ROUTING_KEY = "persistence.data";
    private final RabbitTemplate rabbitTemplate;

    public ProcessedDataPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(SensorData data) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY, data);
    }
}