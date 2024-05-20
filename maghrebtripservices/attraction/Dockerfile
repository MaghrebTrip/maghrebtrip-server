FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.attraction="beta"
COPY target/attraction.jar attraction.jar
ENTRYPOINT ["java","-jar","/attraction.jar"]