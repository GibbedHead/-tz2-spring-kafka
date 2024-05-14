package ru.chaplyginma.monitoredapp.metrics.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricsDto {
    String metricName;
    Double value;
    LocalDateTime timestamp;
}
