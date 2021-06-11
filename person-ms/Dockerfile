FROM openjdk:8-jdk-alpine
VOLUME /person-ms
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} person-ms.jar
ENTRYPOINT ["java","-jar","/person-ms.jar"]