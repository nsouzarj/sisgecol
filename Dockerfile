FROM openjdk:latest
#FROM library/tomcat:9.0.71-jdk8-corretto-al2

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 5432
EXPOSE 8082