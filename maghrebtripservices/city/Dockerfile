FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.city="beta"
COPY target/city.jar city.jar
ENTRYPOINT ["java","-jar","/city.jar"]