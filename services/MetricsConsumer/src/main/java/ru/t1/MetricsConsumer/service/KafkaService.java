package ru.t1.MetricsConsumer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.t1.MetricsConsumer.exception.ServiceException;
import ru.t1.MetricsConsumer.model.Metric;
import ru.t1.MetricsConsumer.repository.MetricRepository;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaService {

    private final MetricRepository repository;

    @KafkaListener(topics = "metrics-topic")
    public void receiveMessages(Metric msg) throws ServiceException {
        log.info("Получено сообщение: {}", msg);
        try {
            repository.save(msg);
        } catch (Exception e) {
            throw new ServiceException("Error in repository.save(msg)", e);
        }
    }
}
