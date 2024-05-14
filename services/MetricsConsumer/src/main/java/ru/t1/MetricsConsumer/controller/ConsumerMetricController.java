package ru.t1.MetricsConsumer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.t1.MetricsConsumer.dto.MetricDto;
import ru.t1.MetricsConsumer.exception.ServiceException;
import ru.t1.MetricsConsumer.service.MetricService;

import java.util.List;

@Tag(
        name="Контроллер просмотра метрик",
        description="API для предоставления информации по метрикам"
)
@RestController
@AllArgsConstructor
@RequestMapping("/metrics")
public class ConsumerMetricController {

    private final MetricService service;

    @Operation(
            summary = "Все метрики",
            description = "Получение списка всех метрик"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MetricDto> metrics() throws ServiceException {
        return service.findAllMetrics();
    }

    @Operation(
            summary = "Метрика по id",
            description = "Получение конкретной метрики по идентификатору"
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MetricDto metric(@PathVariable Long id) throws ServiceException {
        return service.findMetricById(id);
    }
}
