package ru.chaplyginma.metricsconsumer.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.chaplyginma.metricsconsumer.model.Metric;
import ru.chaplyginma.metricsconsumer.testdata.TestData;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Transactional
public class MetricsRepositoryTests {
    @Autowired
    private MetricsRepository metricsRepository;

    @Test
    public void givenValidMetric_whenSave__thenMetricReturned() {
        Metric metric = TestData.getValidNewMetric();

        Metric savedMetric = metricsRepository.save(metric);

        assertThat(savedMetric.getMetricName()).isEqualTo(metric.getMetricName());
    }

    @Test
    public void whenFindDistinctMetricNames_thenShouldReturnDistinctMetricNames() {
        Metric metric11 = TestData.getIthMetric(1, "Some metric 1");
        Metric metric12 = TestData.getIthMetric(2, "Some metric 1");
        Metric metric21 = TestData.getIthMetric(3, "Some metric 2");
        Metric metric22 = TestData.getIthMetric(4, "Some metric 2");
        Metric metric31 = TestData.getIthMetric(5, "Some metric 3");

        metricsRepository.save(metric11);
        metricsRepository.save(metric12);
        metricsRepository.save(metric21);
        metricsRepository.save(metric22);
        metricsRepository.save(metric31);

        List<String> distinctMetricNames = metricsRepository.findDistinctMetricNames();

        assertThat(distinctMetricNames.size()).isEqualTo(3);
    }

    @Test
    public void givenValidMetricName_whenFindByMetricName_thenShouldReturnListOfMetrics() {
        Metric metric11 = TestData.getIthMetric(1, "Some metric 1");
        Metric metric12 = TestData.getIthMetric(2, "Some metric 1");
        Metric metric21 = TestData.getIthMetric(3, "Some metric 2");
        Metric metric22 = TestData.getIthMetric(4, "Some metric 2");
        Metric metric31 = TestData.getIthMetric(5, "Some metric 3");

        metric11.setId(null);
        metric12.setId(null);
        metric21.setId(null);
        metric22.setId(null);
        metric31.setId(null);

        metricsRepository.save(metric11);
        metricsRepository.save(metric12);
        metricsRepository.save(metric21);
        metricsRepository.save(metric22);
        metricsRepository.save(metric31);

        List<Metric> metricsByName = metricsRepository.findMetricsByNameAndOptionalDateRange("Some metric 1", null, null);

        assertThat(metricsByName.size()).isEqualTo(2);
    }
}
