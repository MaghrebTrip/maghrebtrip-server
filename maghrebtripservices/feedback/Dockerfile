FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.feedback="beta"
COPY target/feedback.jar feedback.jar
ENTRYPOINT ["java","-jar","/feedback.jar"]