FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.city="beta"
COPY target/city.jar city.jar
COPY target/classes/cities.csv cities.csv
ENTRYPOINT ["java","-jar","/city.jar"]