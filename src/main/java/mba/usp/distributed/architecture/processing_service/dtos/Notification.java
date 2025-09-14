package mba.usp.distributed.architecture.processing_service.dtos;

import java.time.LocalDateTime;

public class Notification {
    private String id;
    private String message;
    private LocalDateTime timestamp;
    private String sensorId;
    private long startProcessingTimestamp;

    public Notification(String id, String message, LocalDateTime timestamp, String sensorId, long startProcessingTimestamp) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.sensorId = sensorId;
        this.startProcessingTimestamp = startProcessingTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public long getStartProcessingTimestamp() {return startProcessingTimestamp;}

    public void setStartProcessingTimestamp(long startProcessingTimestamp) {this.startProcessingTimestamp = startProcessingTimestamp;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

}