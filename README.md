## Micronaut 4.6.0 Documentation

- [User Guide](https://docs.micronaut.io/4.6.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.6.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.6.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature ksp documentation

- [Micronaut Kotlin Symbol Processing (KSP) documentation](https://docs.micronaut.io/latest/guide/#kotlin)

- [https://kotlinlang.org/docs/ksp-overview.html](https://kotlinlang.org/docs/ksp-overview.html)

## API:
-  Добавление транзакции POST /transactions/save; пример тела запроса:{"amount" : "123", "category" : "INCOME", "userId" : "2"}
- Получение транзакции GET /transactions/getall; пример параметров запроса: user_id=2, page=0, size=10
- Логин пользователя POST /users/login; пример тела запроса: {"username": "Lasa", "password": "Lasa"}

## Для сборки:
- Собрать проект, используя gradlew и плагин shadowJar (добавить +x для gradlew, если ./gradlew не найден)
- Используя docker build собрать образ под названием "app"
- Далее использовать docker compose up