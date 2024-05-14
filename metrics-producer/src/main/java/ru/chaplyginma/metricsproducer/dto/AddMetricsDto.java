package ru.chaplyginma.metricsproducer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricsDto {
    @NotBlank
    String metricName;
    Double value;
    @NotNull
    LocalDateTime timestamp;
}
