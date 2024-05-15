package ru.chaplyginma.metricsconsumer.exception.model;

public class InvalidMetricsException extends RuntimeException {
    public InvalidMetricsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMetricsException(String message) {
        super(message);
    }
}
