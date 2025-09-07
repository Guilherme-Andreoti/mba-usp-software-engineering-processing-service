package mba.usp.distributed.architecture.processing_service.service;

import mba.usp.distributed.architecture.processing_service.messaging.NotificationDataPublisher;
import mba.usp.distributed.architecture.processing_service.model.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationHandler {

    private final NotificationDataPublisher publisher;

    public NotificationHandler(NotificationDataPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendNotification(String message, LocalDateTime datetime, String sensor){
        this.publisher.publish(new Notification(
                message,
                datetime,
                sensor
        ));

    }
}
