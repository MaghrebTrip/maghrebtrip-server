FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.trip="beta"
COPY target/trip.jar trip.jar
ENTRYPOINT ["java","-jar","/trip.jar"]