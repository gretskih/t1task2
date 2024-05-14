package ru.t1.MetricsProducer.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Сущность метрика")
public record Metric(LocalDateTime time, String name, Long value) {
}
