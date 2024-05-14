package ru.t1.MetricsConsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.MetricsConsumer.model.Metric;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    Metric findMetricById(Long id);
}
