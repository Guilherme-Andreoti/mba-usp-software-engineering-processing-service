package mba.usp.distributed.architecture.processing_service.service;

import mba.usp.distributed.architecture.processing_service.model.SensorData;
import mba.usp.distributed.architecture.processing_service.messaging.ProcessedDataPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataProcessor {


    private final ProcessedDataPublisher processedDataPublisher;
    private final NotificationHandler notificationHandler;
    private final AnomalyDetector anomalyDetector;

    public SensorDataProcessor(ProcessedDataPublisher processedDataPublisher, NotificationHandler notificationHandler, AnomalyDetector anomalyDetector) {
        this.processedDataPublisher = processedDataPublisher;
        this.notificationHandler = notificationHandler;
        this.anomalyDetector = anomalyDetector;
    }

    public void process(SensorData data) {

        List<String> anomalies = this.anomalyDetector.detect(data);

        if (!anomalies.isEmpty())  anomalies.forEach(anomaly -> {notificationHandler.sendNotification(anomaly,data.getDateTime(),data.getTopic());});

        processedDataPublisher.publish(data);
    }

}
