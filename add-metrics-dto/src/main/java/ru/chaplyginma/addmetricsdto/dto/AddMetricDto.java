package ru.chaplyginma.addmetricsdto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricDto {
    @NotBlank
    @Size(max = 255)
    @Schema(description = "Name of the metric", example = "CPU Usage")
    String metricName;
    @Schema(description = "Value of the metric", example = "0.75")
    Double value;
    @NotNull
    @Schema(description = "Timestamp of the metric data", example = "2024-05-16T12:00:00")
    LocalDateTime timestamp;
}