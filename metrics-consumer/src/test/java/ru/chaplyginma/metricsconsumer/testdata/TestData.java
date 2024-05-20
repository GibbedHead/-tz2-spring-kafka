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
        responseDto.setMetricValue((double) i);
        responseDto.setMetricTimestamp(LocalDateTime.now());

        return responseDto;
    }

    public static Metric getIthMetric(int i) {
        Metric metric = new Metric();
        metric.setId((long) i);
        metric.setMetricName("Some metric");
        metric.setMetricValue((double) i);
        metric.setMetricTimestamp(LocalDateTime.now());

        return metric;
    }

    public static Metric getValidNewMetric() {
        Metric metric = new Metric();
        metric.setMetricName("Some metric");
        metric.setMetricValue(1.0);
        metric.setMetricTimestamp(LocalDateTime.now());
        return metric;
    }

    public static Metric getNullNameNewMetric() {
        Metric metric = new Metric();
        metric.setMetricValue(1.0);
        metric.setMetricTimestamp(LocalDateTime.now());
        return metric;
    }

    public static AddMetricDto getValidAddMetricDto() {
        return AddMetricDto.builder()
                .metricName("Some metric")
                .metricValue(1.0)
                .metricTimestamp(LocalDateTime.now())
                .build();
    }

    public static Metric getValidMetricForValidAddMetricDto() {
        Metric metric = new Metric();
        metric.setId(1L);
        metric.setMetricName("Some metric");
        metric.setMetricValue(1.0);
        metric.setMetricTimestamp(LocalDateTime.now());
        return metric;
    }

    public static AddMetricDto getBlankNameAddMetricDto() {
        return AddMetricDto.builder()
                .metricName("")
                .metricValue(1.0)
                .metricTimestamp(LocalDateTime.now())
                .build();
    }
}
