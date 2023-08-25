FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/HR-webapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9001

CMD ["java", "-jar", "app.jar"]