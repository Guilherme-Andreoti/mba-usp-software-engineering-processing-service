package mba.usp.distributed.architecture.processing_service.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import mba.usp.distributed.architecture.processing_service.model.SensorData;
import mba.usp.distributed.architecture.processing_service.service.SensorDataProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SensorDataListener {

    private final ObjectMapper objectMapper;
    private final SensorDataProcessor processor;
    private SensorData message;

    public SensorDataListener(ObjectMapper objectMapper, SensorDataProcessor processor) {
        this.objectMapper = objectMapper;
        this.processor = processor;
    }
    @RabbitListener(queues = "sensor.data.queue")
    public void handleSensorData(SensorData message) {
        this.message = message;
        try {
            System.out.println(message);
            processor.process(message);
        } catch (Exception e) {
            System.err.println("❌ Falha ao processar mensagem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
