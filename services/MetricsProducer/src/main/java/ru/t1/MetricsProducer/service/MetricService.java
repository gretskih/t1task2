package ru.t1.MetricsProducer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.t1.MetricsProducer.domain.Metric;
import ru.t1.MetricsProducer.exception.ServiceException;

@Service
@AllArgsConstructor
@Slf4j
public class MetricService {

    private final KafkaTemplate<String, Object> template;

    public void sendMsg(Metric msg) throws ServiceException {
        log.info("Отправка сообщения: {}", msg);
        try {
            template.send("metrics-topic", msg);
        } catch (Exception e) {
            throw new ServiceException("Error sending the message", e);
        }
    }

}
