# Order Service

**Order Service** — микросервис проекта BikeBuilder для управления заказами пользователей,
включая создание и удаление заказов.

## Основные возможности

- Создание нового заказа.
- Удаление всех заказов пользователя при получении события Kafka об удалении данного пользователя.

---

## Архитектура

- Hexagonal Architecture (Ports & Adapters)
- Event-driven через Kafka для обмена событиями между микросервисами
- PostgreSQL для хранения данных
- Gradle для сборки проекта
- Docker для контейнеризации

---

## Структура проекта

```
src/
├─ main/
│ ├─ java/com/bikebuilder/orderservice/
│ │ ├─ adapter/in/web/ # REST контроллеры и DTO
│ │ ├─ adapter/out/persistence/ # Адаптеры для работы с БД (Entity, Repository, Adapter)
│ │ ├─ adapter/out/messaging/ # Слушаем события от User Service
│ │ ├─ application/port/ # Порты для Hexagonal архитектуры
│ │ ├─ application/usecase/ # Реализация бизнес-логики
│ │ ├─ config/ # Конфигурации Kafka
│ │ └─ domain/ # Доменные модели (Order и OrderItem) и enum (OrderStatus)
│ └─ resources/
│ ├─ application.yaml
│ └─ db/changelog/ # Миграции для базы данных
└─ test/ # Unit и Integration тесты
```

---

## Сборка и запуск

### Локально

```bash
./gradlew build
./gradlew bootRun
```

### С Docker

```bash
docker-compose up -d
```
- Контейнер поднимает PostgreSQL

---

## Технологии

- Java 24
- Spring Boot 3.5.4
- PostgreSQL 16
- Kafka
- Gradle
- JUnit 5, Mockito

---

## Миграции базы данных

- Используется Liquibase через YAML миграции: src/main/resources/db/changelog/
- Пример: 010-init-db-schema.yaml

## TODO

- Добавить интеграционные и юнит тесты.