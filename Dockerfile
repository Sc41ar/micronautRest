#Dockerfile 

# Базовый образ openjdk
FROM eclipse-temurin:21

# Рабочая директория
WORKDIR /usr/src/micronaut

# Копирование файлов из build context
COPY ./build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]