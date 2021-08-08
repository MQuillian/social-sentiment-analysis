FROM openjdk:11
ARG JAR_FILE
COPY *.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]