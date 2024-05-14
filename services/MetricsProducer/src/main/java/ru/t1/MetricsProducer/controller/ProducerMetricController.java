package ru.t1.MetricsProducer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.t1.MetricsProducer.domain.Metric;
import ru.t1.MetricsProducer.exception.ServiceException;
import ru.t1.MetricsProducer.service.MetricService;

@Tag(
        name="Контроллер сбора метрик",
        description="API для отправки метрик в сервис по хранению статистики"
)
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ProducerMetricController {

    private final MetricService service;

    @Operation(
            summary = "Отправка метрики",
            description = "Отправка метрик работы приложения в формате JSON"
    )
    @PostMapping("metrics")
    @ResponseStatus(HttpStatus.OK)
    public void sendMetric(@RequestBody Metric metric) throws ServiceException {
        service.sendMsg(metric);
    }
}
