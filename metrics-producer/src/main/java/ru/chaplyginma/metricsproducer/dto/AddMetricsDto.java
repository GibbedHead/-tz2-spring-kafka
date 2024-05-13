package ru.chaplyginma.metricsproducer.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricsDto {
    String metricName;
    Double value;
    Long timestamp;
}
