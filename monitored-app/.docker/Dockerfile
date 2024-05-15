FROM eclipse-temurin:17-jdk-alpine

RUN addgroup -S app && adduser -S app -G app

USER app

COPY monitored-app/target/*.jar app.jar
COPY .env .env
ENTRYPOINT ["java","-jar","/app.jar"]