FROM openjdk:17-jdk-slim
LABEL authors="jonichi"
COPY target/peridot-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]