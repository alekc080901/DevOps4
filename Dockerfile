FROM openjdk:21-slim

COPY ../build/source-service.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]