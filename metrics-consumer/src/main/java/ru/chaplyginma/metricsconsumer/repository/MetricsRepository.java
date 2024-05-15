package ru.chaplyginma.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.chaplyginma.metricsconsumer.model.Metric;

import java.util.List;

public interface MetricsRepository extends JpaRepository<Metric, Long> {
    @Query("SELECT DISTINCT m.metricName FROM Metric m")
    List<String> findDistinctMetricNames();

}
