package ru.chaplyginma.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.chaplyginma.metricsconsumer.model.Metric;

import java.time.LocalDateTime;
import java.util.List;

public interface MetricsRepository extends JpaRepository<Metric, Long> {
    @Query("SELECT DISTINCT m.metricName FROM Metric m")
    List<String> findDistinctMetricNames();

    @Query("SELECT m FROM Metric m WHERE m.metricName = :metricName " +
            "AND (COALESCE(:startDate, m.timestamp) <= m.timestamp) " +
            "AND (COALESCE(:endDate, m.timestamp) >= m.timestamp)")
    List<Metric> findMetricsByNameAndOptionalDateRange(
            @Param("metricName") String metricName,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );
}
