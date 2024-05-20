package ru.chaplyginma.metricsproducer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.chaplyginma.metricsproducer.service.MetricsService;
import ru.chaplyginma.metricsproducer.testdata.TestData;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MetricsController.class)
public class MetricsControllerTests {
    private static final String API_URL = "/metrics";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MetricsService metricsService;

    @Test
    public void givenValidAddMetricDto_whenPostMetrics_thenOk() throws Exception {
        objectMapper.registerModule(new JavaTimeModule());

        given(metricsService.sendMetrics(any()))
                .willReturn("Successfully sent to Kafka");

        String validDtoJson = objectMapper.writeValueAsString(TestData.getValidAddMetricDto());

        mockMvc.perform(MockMvcRequestBuilders.post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validDtoJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("Successfully sent to Kafka"));
    }

    @Test
    public void givenInvalidAddMetricDto_whenPostMetrics_thenBadRequest() throws Exception {
        objectMapper.registerModule(new JavaTimeModule());

        given(metricsService.sendMetrics(any()))
                .willReturn("Successfully sent to Kafka");

        String validDtoJson = objectMapper.writeValueAsString(TestData.getBlankNameAddMetricDto());

        mockMvc.perform(MockMvcRequestBuilders.post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(validDtoJson))
                .andExpect(status().isBadRequest());
    }
}
