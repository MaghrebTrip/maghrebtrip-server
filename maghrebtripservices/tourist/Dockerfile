FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.tourist="beta"
COPY target/tourist.jar tourist.jar
ENTRYPOINT ["java","-jar","/tourist.jar"]