package ru.chaplyginma.monitoredapp.metrics.fetcher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MetricsFetcher {
    private final MetricsEndpoint metricsEndpoint;

    public void getCPUUsageFromActuator() {
        MetricsEndpoint.MetricDescriptor response = metricsEndpoint.metric("system.cpu.usage", null);

        log.info(response.toString());
    }
}
