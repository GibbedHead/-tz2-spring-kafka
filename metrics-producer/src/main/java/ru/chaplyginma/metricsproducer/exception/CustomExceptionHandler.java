package ru.chaplyginma.metricsproducer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.chaplyginma.metricsproducer.exception.model.SendToKafkaException;

@RestControllerAdvice("ru.chaplyginma.metricsproducer")
public class CustomExceptionHandler {

    @ExceptionHandler(SendToKafkaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleSendToKafkaException(SendToKafkaException e) {
        return e.getMessage();
    }
}
