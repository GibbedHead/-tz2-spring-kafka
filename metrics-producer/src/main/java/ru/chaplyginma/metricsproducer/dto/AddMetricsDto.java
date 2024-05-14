package ru.chaplyginma.metricsproducer.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricsDto {
    String metricName;
    Double value;
    LocalDateTime timestamp;
}
