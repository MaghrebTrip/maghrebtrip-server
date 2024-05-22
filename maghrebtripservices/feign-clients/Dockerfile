FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.feign-clients="beta"
COPY target/feign-clients.jar feign-clients.jar
ENTRYPOINT ["java","-jar","/feign-clients.jar"]