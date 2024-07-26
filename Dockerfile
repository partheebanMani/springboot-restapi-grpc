FROM maven:3-openjdk-17
EXPOSE 8081 9090
ARG JAR_FILE=target/springboot-rest-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]