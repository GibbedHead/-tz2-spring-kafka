package ru.chaplyginma.metricsconsumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.chaplyginma.metricsconsumer.dto.AddMetricsDto;
import ru.chaplyginma.metricsconsumer.model.Metrics;

@Mapper(componentModel = "spring")
public interface MetricsMapper {
    @Mapping(target = "id", ignore = true)
    Metrics addMetricsDtoToMetrics(AddMetricsDto addMetricsDto);
}
