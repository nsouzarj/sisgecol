#FROM openjdk:latest
#FROM library/tomcat:9.0.71-jdk8-corretto-al2
FROM debian:latest
RUN apt-get update -y
#RUN apt-get upgrade -y
#RUN apt-cache search openjdk
RUN apt-get install openjdk-11-jdk -y
RUN echo "JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/" >> /etc/environment
#RUN source /etc/environment
RUN echo $JAVA_HOME

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 5432
EXPOSE 8084
