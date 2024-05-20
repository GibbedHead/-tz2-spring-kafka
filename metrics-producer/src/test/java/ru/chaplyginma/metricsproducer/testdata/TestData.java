package ru.chaplyginma.metricsproducer.testdata;

import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;

import java.time.LocalDateTime;

public class TestData {
    public static AddMetricDto getValidAddMetricDto() {
        return AddMetricDto.builder()
                .metricName("Some metric")
                .metricValue(1.0)
                .metricTimestamp(LocalDateTime.now())
                .build();
    }

    public static AddMetricDto getBlankNameAddMetricDto() {
        return AddMetricDto.builder()
                .metricName("")
                .metricValue(1.0)
                .metricTimestamp(LocalDateTime.now())
                .build();
    }
}
