# This Dockerfile uses a multi-stage build to create a small and efficient image for your Spring Boot application.

# Stage 1: Build the application with Maven
# We use a base image that includes Maven and OpenJDK 17 to compile the project.
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copy the project's pom.xml to download dependencies and then copy the source code.
# Copying pom.xml separately can leverage Docker's build cache if dependencies don't change.
COPY pom.xml .
COPY src ./src
# Run the Maven command to clean, compile, and package the application into a JAR file.
# -DskipTests is used to skip running tests, which is common for deployment builds.
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lean image with just a JRE
# We switch to a smaller base image that only contains the Java Runtime Environment (JRE).
# This JRE is sufficient to run the application, making the final image smaller and more secure.
FROM eclipse-temurin:17-jre-focal
# Set the working directory in the new, lean container.
WORKDIR /app
# Copy only the built JAR file from the 'build' stage into this final image.
# This prevents copying unnecessary build tools and source code, keeping the image small.
COPY --from=build /app/target/BugTracking-0.0.1-SNAPSHOT.jar .
# Expose the port on which the Spring Boot application listens.
# This is mainly for documentation; Render will handle port mapping.
EXPOSE 8092
# Define the command to run the application when the container starts.
CMD ["java", "-jar", "BugTracking-0.0.1-SNAPSHOT.jar"]
