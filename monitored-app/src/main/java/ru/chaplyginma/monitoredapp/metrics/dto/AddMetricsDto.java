package ru.chaplyginma.monitoredapp.metrics.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricsDto {
    String metricName;
    Double value;
    LocalDateTime timestamp;
}
