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
                .metricValue(0.0)
                .metricTimestamp(LocalDateTime.now())
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void givenBlankMetricName_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName(" ")
                .metricValue(0.0)
                .metricTimestamp(LocalDateTime.now())
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void givenTooLongMetricName_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName("a".repeat(256))
                .metricValue(0.0)
                .metricTimestamp(LocalDateTime.now())
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void givenNullTimestamp_whenValidate_thenNotValid() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName("Some metric")
                .metricValue(0.0)
                .metricTimestamp(null)
                .build();

        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        assertThat(violations.size()).isEqualTo(1);
    }
}