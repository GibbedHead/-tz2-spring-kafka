package ru.chaplyginma.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chaplyginma.metricsconsumer.model.Metrics;

public interface MetricsRepository extends JpaRepository<Metrics, Long> {
}
