package ru.chaplyginma.metricsconsumer.testdata;

import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.dto.MetricResponseDto;
import ru.chaplyginma.metricsconsumer.model.Metric;

import java.time.LocalDateTime;
import java.util.List;

public class TestData {
    public static List<String> getDistinctMetricNames() {
        return List.of("Some metric1", "Some metric2", "Some metric3");
    }

    public static MetricResponseDto getIthMetricResponseDto(int i) {
        MetricResponseDto responseDto = new MetricResponseDto();
        responseDto.setId((long) i);
        responseDto.setMetricName("Some metric");
        responseDto.setValue((double) i);
        responseDto.setTimestamp(LocalDateTime.now());

        return responseDto;
    }

    public static Metric getIthMetric(int i) {
        Metric metric = new Metric();
        metric.setId((long) i);
        metric.setMetricName("Some metric");
        metric.setValue((double) i);
        metric.setTimestamp(LocalDateTime.now());

        return metric;
    }

    public static AddMetricDto getValidAddMetricDto() {
        return AddMetricDto.builder()
                .metricName("Some metric")
                .value(1.0)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static Metric getValidMetricForValidAddMetricDto() {
        Metric metric = new Metric();
        metric.setId(1L);
        metric.setMetricName("Some metric");
        metric.setValue(1.0);
        metric.setTimestamp(LocalDateTime.now());
        return metric;
    }

    public static AddMetricDto getBlankNameAddMetricDto() {
        return AddMetricDto.builder()
                .metricName("")
                .value(1.0)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
