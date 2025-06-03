# Etapa 1: Build
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# Etapa 2: Run
FROM eclipse-temurin:21-jre

WORKDIR /app

# Gradle genera los .jar aquí:
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]