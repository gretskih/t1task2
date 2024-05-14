package ru.t1.MetricsConsumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Сущность метрика")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "metric")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "time_m")
    private LocalDateTime time;
    private String name;
    @Column(name = "value_m")
    private Long value;
}
