package ru.t1.MetricsConsumer.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import ru.t1.MetricsConsumer.dto.MetricDto;
import ru.t1.MetricsConsumer.exception.ServiceException;
import ru.t1.MetricsConsumer.repository.MetricRepository;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class MetricService {

    private final MetricRepository repository;
    private final ModelMapper modelMapper;

    public List<MetricDto> findAllMetrics() throws ServiceException {
        try {
            var metrics = repository.findAll();
            Type listType = new TypeToken<List<MetricDto>>() {}.getType();
            return modelMapper.map(metrics, listType);
        } catch (Exception e) {
            throw new ServiceException("Error in findAllMetrics()", e);
        }
    }

    public MetricDto findMetricById(Long id) throws ServiceException {
        try {
            var metric = repository.findMetricById(id);
            return modelMapper.map(metric, MetricDto.class);
        } catch (Exception e) {
            throw new ServiceException("Error in findMetricById()", e);
        }
    }
}
