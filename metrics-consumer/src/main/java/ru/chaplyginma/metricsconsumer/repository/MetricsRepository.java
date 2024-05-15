package ru.chaplyginma.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaplyginma.metricsconsumer.model.Metric;

public interface MetricsRepository extends JpaRepository<Metric, Long> {
}
