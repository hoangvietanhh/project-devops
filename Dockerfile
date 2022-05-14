FROM openjdk:8-jdk-alpine

ADD target/project-devops-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT exec java -jar app.jar