# Use the official Maven image with Eclipse Temurin JDK 21 to build the application
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the project into the container
COPY . .

# Run 'mvn generate-sources' to generate code from OpenAPI specifications
RUN mvn generate-sources

# Build the application artifact
RUN mvn clean package -DskipTests

# Use a minimal Eclipse Temurin JDK 21 image to run the application
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the JAR generated in the build stage
COPY --from=builder /app/target/parking-meter-0.0.1-SNAPSHOT.jar /app/parking-meter.jar

# Expose ports 8080 and 8081
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "parking-meter.jar"]

LABEL authors="iagoomes"