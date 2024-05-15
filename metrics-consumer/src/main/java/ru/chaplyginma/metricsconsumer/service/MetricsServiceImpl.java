package ru.chaplyginma.metricsconsumer.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.chaplyginma.metricsconsumer.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.exception.model.InvalidMetricsException;
import ru.chaplyginma.metricsconsumer.mapper.MetricsMapper;
import ru.chaplyginma.metricsconsumer.repository.MetricsRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MetricsServiceImpl implements MetricsService {
    private final MetricsRepository metricsRepository;
    private final MetricsMapper metricsMapper = Mappers.getMapper(MetricsMapper.class);
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Override
    public void save(AddMetricDto addMetricDto) {
        Set<ConstraintViolation<AddMetricDto>> violations = validator.validate(addMetricDto);
        if (!violations.isEmpty()) {
            throw new InvalidMetricsException(
                    violations
                            .stream()
                            .map(
                                    violation -> "Property: " + violation.getPropertyPath() +
                                            ", Error: " + violation.getMessage()
                            )
                            .collect(
                                    Collectors.joining("; ")
                            )
            );
        }
        metricsRepository.save(
                metricsMapper.addMetricDtoToMetric(
                        addMetricDto
                )
        );
    }

    @Override
    public List<String> getUniqueMetricNames() {
        return metricsRepository.findDistinctMetricNames();
    }
}
