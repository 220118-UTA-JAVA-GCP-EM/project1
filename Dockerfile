FROM openjdk:8-jdk-alpine
COPY build/libs/project1-1.0-SNAPSHOT.jar project1.jar
CMD ["java", "-jar", "project1.jar"]