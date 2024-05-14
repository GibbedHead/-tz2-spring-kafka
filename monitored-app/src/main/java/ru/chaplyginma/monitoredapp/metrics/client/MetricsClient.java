package ru.chaplyginma.monitoredapp.metrics.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import ru.chaplyginma.monitoredapp.metrics.dto.AddMetricsDto;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MetricsClient {
    @Value("${metricsproducer.api-url}")
    private String metricsProducerApiUrl;

    public void postMetric(String metricName, Double metricValue) {
        AddMetricsDto addMetricsDto = AddMetricsDto.builder()
                .metricName(metricName)
                .value(metricValue)
                .timestamp(LocalDateTime.now())
                .build();
        WebClient webClient = WebClient.create(metricsProducerApiUrl);
        webClient
                .post()
                .uri("")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(addMetricsDto))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(
                        response -> log.info("Metric '{}' saved successfully", metricName),
                        error -> {
                            String errorMessage;
                            if (error instanceof WebClientResponseException responseException) {
                                errorMessage = responseException.getResponseBodyAsString();
                            } else {
                                errorMessage = error.getMessage();
                            }
                            log.error(
                                    "Metric '{}' save failed. Error: {}",
                                    metricName,
                                    errorMessage
                            );
                        }
                );
    }
}
