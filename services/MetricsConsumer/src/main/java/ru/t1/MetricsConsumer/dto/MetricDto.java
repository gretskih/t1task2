package ru.t1.MetricsConsumer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Сущность метрика дто")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MetricDto {
    private LocalDateTime time;
    private String name;
    private Long value;
}
