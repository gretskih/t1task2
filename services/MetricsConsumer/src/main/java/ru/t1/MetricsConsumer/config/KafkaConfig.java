package ru.t1.MetricsConsumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic oneRequests() {
        return TopicBuilder.name("metrics-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        org.modelmapper.config.Configuration conf = modelMapper.getConfiguration();
        conf.setFieldMatchingEnabled(true);
        conf.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        conf.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return modelMapper;
    }
}
