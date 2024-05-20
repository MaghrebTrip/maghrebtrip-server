FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.eureka-server="beta"
COPY target/eureka-server.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]