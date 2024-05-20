package ru.chaplyginma.metricsconsumer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.testdata.TestData;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@EmbeddedKafka(partitions = 1, topics = {"metrics"})
public class MetricsKafkaListenerTests {
    @Autowired
    private KafkaTemplate<String, AddMetricDto> kafkaTemplate;

    @MockBean
    private MetricsService metricsService;

    @Test
    public void testListenMetrics() throws InterruptedException {
        AddMetricDto addMetricDto = TestData.getValidAddMetricDto();

        kafkaTemplate.send("metrics", addMetricDto);

        Thread.sleep(5000);

        verify(metricsService, times(1)).save(addMetricDto);
    }

}
