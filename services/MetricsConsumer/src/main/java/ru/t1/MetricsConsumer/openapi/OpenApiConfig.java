package ru.t1.MetricsConsumer.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Metric Consumer",
                description = "Cервис принимает метрики из Kafka топика \"metrics-topic\" и сохраняет в базу данных", version = "1.0.0",
                contact = @Contact(
                        name = "Anatoly",
                        email = "gretskih@mail.ru"
                )
        )
)
public class OpenApiConfig {
}
