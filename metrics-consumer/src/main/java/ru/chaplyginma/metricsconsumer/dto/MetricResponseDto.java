package ru.chaplyginma.metricsconsumer.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MetricResponseDto {
    Long id;
    String metricName;
    Double value;
    LocalDateTime timestamp;
}
