# Use a Maven image to build the project
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use a slim JDK image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/peridot-0.0.1.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]