package ru.chaplyginma.monitoredapp.metrics.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.chaplyginma.monitoredapp.metrics.client.MetricsClient;
import ru.chaplyginma.monitoredapp.metrics.exception.InvalidMetricException;
import ru.chaplyginma.monitoredapp.metrics.fetcher.MetricsFetcher;

@Component
@RequiredArgsConstructor
@Slf4j
public class MetricsSender {
    private final MetricsFetcher fetcher;
    private final MetricsClient metricsClient;
    @Value("${app.monitored.metrics}")
    private String[] monitoredMetrics;

    @Scheduled(fixedRate = 6000)
    public void sendMetrics() {
        for (String metric : monitoredMetrics) {
            try {
                double value = fetcher.getMetricFromActuator(metric);
                metricsClient.postMetric(metric, value);
            } catch (InvalidMetricException e) {
                log.error(e.getMessage());
            }
        }
    }
}
