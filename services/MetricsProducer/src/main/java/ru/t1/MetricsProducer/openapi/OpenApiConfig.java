package ru.t1.MetricsProducer.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Metric Producer",
                description = "Cервис отправляет метрики в Kafka топик \"metrics-topic\"", version = "1.0.0",
                contact = @Contact(
                        name = "Anatoly",
                        email = "gretskih@mail.ru"
                )
        )
)
public class OpenApiConfig {
}
