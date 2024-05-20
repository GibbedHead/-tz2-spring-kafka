package ru.chaplyginma.metricsconsumer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.chaplyginma.metricsconsumer.dto.MetricResponseDto;
import ru.chaplyginma.metricsconsumer.exception.model.InvalidMetricsException;
import ru.chaplyginma.metricsconsumer.repository.MetricsRepository;
import ru.chaplyginma.metricsconsumer.testdata.TestData;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MetricsServiceImplTests {
    @Mock
    private MetricsRepository metricsRepository;

    @InjectMocks
    private MetricsServiceImpl metricsService;

    @Test
    public void givenValidAddMetricDto_whenSave_thenNoExceptions() {
        given(metricsRepository.save(any()))
                .willReturn(TestData.getValidMetricForValidAddMetricDto());

        assertThatCode(() -> metricsService.save(TestData.getValidAddMetricDto()))
                .doesNotThrowAnyException();
    }

    @Test
    public void givenInvalidAddMetricDto_whenSave_thenInvalidMetricsExceptionExceptions() {
        assertThatThrownBy(() -> metricsService.save(TestData.getBlankNameAddMetricDto()))
                .isInstanceOf(InvalidMetricsException.class);
    }

    @Test
    public void whenGetUniqueMetricNames_thenReturnMetricNamesList() {
        given(metricsRepository.findDistinctMetricNames())
                .willReturn(TestData.getDistinctMetricNames());

        List<String> uniqueMetricNames = metricsService.getUniqueMetricNames();

        assertThat(uniqueMetricNames).isNotEmpty();
        assertThat(uniqueMetricNames.get(0)).isEqualTo(TestData.getDistinctMetricNames().get(0));
    }

    @Test
    public void whenGetMetricsByName_thenReturnMetricResponseDtoList() {
        given(metricsRepository.findMetricsByNameAndOptionalDateRange(any(), any(), any()))
                .willReturn(List.of(
                        TestData.getIthMetric(1, "Some metric"),
                        TestData.getIthMetric(2, "Some metric"),
                        TestData.getIthMetric(3, "Some metric")
                ));

        List<MetricResponseDto> metricResponseDtos = metricsService.getMetricsByName("Some metric", null, null);

        assertThat(metricResponseDtos).isNotEmpty();
        assertThat(metricResponseDtos.get(0).getMetricName()).isEqualTo(TestData.getIthMetric(1, "Some metric").getMetricName());
    }


}
