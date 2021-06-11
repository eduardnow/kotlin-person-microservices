FROM openjdk:8-jdk-alpine
VOLUME /person-api
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} person-api.jar
ENTRYPOINT ["java","-jar","/person-api.jar"]