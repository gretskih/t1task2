# Monitoring Service
Система мониторинга с использованием Spring Kafka. <br>
Состоит из следующих микросервисов:
- Metrics Producer: отслеживает и собирает метрики работы приложения и отправлять их в Kafka топик "metrics-topic".
- Metrics Consumer: принимает метрики из Kafka топика "metrics-topic", сохраняет в базу данных.

## Стек технологий
- ![Java 17](https://img.shields.io/badge/Java-17-blue)
- ![Spring 3.2.5](https://img.shields.io/badge/Spring%20Boot%203.2.5-white?style=flat&logo=Spring)
- ![Liquibase 4.24.0](https://img.shields.io/badge/Liquibase_4.24.0-white?style=flat&logo=Liquibase&logoColor=blue
  )
- ![PostgreSQL 42.6.2](https://img.shields.io/badge/PostgreSQL_42.3.8-white?style=flat&logo=PostgreSQL&logoColor=blue
  )
- ![Maven 4.0.0](https://img.shields.io/badge/Maven%204.0.0-white?style=flat&logo=Apache%20Maven&logoColor=red
  )
- ![Lombok 1.18.32](https://img.shields.io/badge/Lombok%201.18.26-white?style=flat
  )
- ![Kafka 3.6.0](https://img.shields.io/badge/Kafka-white?style=flat
  )

## Окружение
- Java 17
- PostgreSQL 16
- Apache Maven 4.0.0

## Запуск проекта
1. Запустить server kafka порт 9092 через терминал или используя файл docker-compose.yml.
2. Скачать архив проекта или клонировать.
3. Запустить микросервис Metrics Producer, для этого из папки services/MetricsProducer выполнить в командной строке

```mvn spring-boot:run```

или после сборки проекта с использованием maven выполнить в командной строке

``` java -jar ./services/MetricsProducer/target/MetricsProducer-0.0.1-SNAPSHOT.jar app.jar```

4. Создать локальную базу данных metric_store, используя интерфейс PostgreSQL 16 или команду:

   ```create database metric_store```

5. В файл конфигурации services/MetricsConsumer/src/main/resources/application.properties внести логин и пароль 
пользователя для доступа к базе данных metric_store.
6. Запустить микросервис Metrics Consumer, для этого из папки services/MetricsProducer выполнить в командной строке

```mvn spring-boot:run```

   или после сборки проекта с использованием maven выполнить в командной строке

   ``` java -jar ./services/MetricsConsumer/target/MetricsConsumer-0.0.1-SNAPSHOT.jar app.jar```

## Описание Producer API

### GET /swagger-ui/index.html - Swagger.

### GET /v3/api-docs - описание API для Swagger.

### POST /metrics - отправка метрик работы приложения в формате JSON.
структура запроса:
```
{
  "time": "2024-05-16T10:58:03.325Z",
  "name": "string",
  "value": 0
}
```

## Описание Consumer API

### GET /swagger-ui/index.html - Swagger.

### GET /v3/api-docs - описание API для Swagger.

### GET /metrics - получение списка всех метрик.
структура ответа:
```
[
  {
    "time": "2024-05-16T11:11:25.778Z",
    "name": "string",
    "value": 0
  }
]
```

### GET /metrics/{id} - получение метрики по ее идентификатору
структура ответа:
```
{
  "time": "2024-05-16T11:12:44.991Z",
  "name": "string",
  "value": 0
}
```

## Контакты

email: gretskih@mail.ru <br/>
telegram: @Anatolij_gr