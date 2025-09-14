package mba.usp.distributed.architecture.processing_service.services;

import mba.usp.distributed.architecture.processing_service.messaging.NotificationDataPublisher;
import mba.usp.distributed.architecture.processing_service.dtos.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationHandler {

    private final NotificationDataPublisher publisher;

    public NotificationHandler(NotificationDataPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendNotification(String id, String message, LocalDateTime datetime, String sensor,long startProcessingTimestamp){
        this.publisher.publish(new Notification(
                id,
                message,
                datetime,
                sensor,
                startProcessingTimestamp
        ));

    }
}
