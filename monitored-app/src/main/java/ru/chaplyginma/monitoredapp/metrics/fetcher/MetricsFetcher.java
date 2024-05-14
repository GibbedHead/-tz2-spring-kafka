package ru.chaplyginma.monitoredapp.metrics.fetcher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;
import ru.chaplyginma.monitoredapp.metrics.exception.InvalidMetricException;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MetricsFetcher {
    private final MetricsEndpoint metricsEndpoint;

    public double getMetricFromActuator(String metricName) throws InvalidMetricException {
        List<MetricsEndpoint.Sample> metric = metricsEndpoint.metric(metricName, null).getMeasurements();
        if (metric.isEmpty() || metric.get(0) == null) {
            throw new InvalidMetricException(String.format("No '%s' metric found", metric));
        }
        return metric.get(0).getValue();
    }
}
