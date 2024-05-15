package ru.chaplyginma.metricsconsumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.chaplyginma.metricsconsumer.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.dto.MetricResponseDto;
import ru.chaplyginma.metricsconsumer.model.Metric;

@Mapper(componentModel = "spring")
public interface MetricsMapper {
    @Mapping(target = "id", ignore = true)
    Metric addMetricDtoToMetric(AddMetricDto addMetricDto);

    MetricResponseDto metricToMetricResponseDto(Metric metric);
}
