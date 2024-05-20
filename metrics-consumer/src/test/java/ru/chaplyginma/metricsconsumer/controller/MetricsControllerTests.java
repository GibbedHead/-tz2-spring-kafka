package ru.chaplyginma.metricsconsumer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.chaplyginma.metricsconsumer.service.MetricsService;
import ru.chaplyginma.metricsconsumer.testdata.TestData;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MetricsController.class)
public class MetricsControllerTests {
    private static final String API_URL = "/metrics";
    private static final String METRIC_URL = API_URL + "/{metricName}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MetricsService metricsService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void whenGetUniqueMetricNames_ThenReturnMetricNamesList() throws Exception {
        given(metricsService.getUniqueMetricNames())
                .willReturn(TestData.getDistinctMetricNames());

        mockMvc.perform(MockMvcRequestBuilders
                        .get(API_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", containsInAnyOrder("Some metric1", "Some metric2", "Some metric3")));
    }

    @Test
    public void givenMetricName_whenGetMetrics_ThenReturnMetricsResponseDtoList() throws Exception {
        given(metricsService.getMetricsByName(anyString(), any(), any()))
                .willReturn(List.of(
                        TestData.getIthMetricResponseDto(1),
                        TestData.getIthMetricResponseDto(2),
                        TestData.getIthMetricResponseDto(3)
                ));

        mockMvc.perform(MockMvcRequestBuilders.get(METRIC_URL, "Some metric"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].value").value(2.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].metricName").value("Some metric"));
    }


}
