package ru.chaplyginma.metricsproducer.exception.model;

public class SendToKafkaException extends RuntimeException {
    public SendToKafkaException(String message, Throwable cause) {
        super(message, cause);
    }
}
