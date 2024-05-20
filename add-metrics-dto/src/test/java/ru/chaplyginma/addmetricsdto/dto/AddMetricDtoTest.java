package ru.chaplyginma.addmetricsdto.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AddMetricDtoTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void givenNullMetricName_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName(null)
                .value(0.0)
                .timestamp(LocalDateTime.now())
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void givenBlankMetricName_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName(" ")
                .value(0.0)
                .timestamp(LocalDateTime.now())
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void givenTooLongMetricName_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName("a".repeat(256))
                .value(0.0)
                .timestamp(LocalDateTime.now())
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void givenNullTimestamp_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName("Some metric")
                .value(0.0)
                .timestamp(null)
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }
}