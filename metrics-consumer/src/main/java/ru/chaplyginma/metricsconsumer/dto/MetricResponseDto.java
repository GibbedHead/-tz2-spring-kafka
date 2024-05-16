package ru.chaplyginma.metricsconsumer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MetricResponseDto {
    @Schema(description = "ID of the metric", example = "1")
    Long id;
    @Schema(description = "Name of the metric", example = "cpu_usage")
    String metricName;
    @Schema(description = "Value of the metric", example = "75.5")
    Double value;
    @Schema(description = "Timestamp of the metric value", example = "2023-05-16T11:57:43")
    LocalDateTime timestamp;
}
