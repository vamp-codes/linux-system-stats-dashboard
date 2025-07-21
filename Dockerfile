FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy everything from project directory into container
COPY . /app/

# DEBUG: Show what got copied into /app
RUN find /app

# Now copy the JAR file (only if the file exists in /app/target)
COPY target/systemstats-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
