FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.attraction="beta"
COPY target/attraction.jar attraction.jar
COPY target/classes/hotels.csv hotels.csv
COPY target/classes/monuments.csv monuments.csv
COPY target/classes/restaurants.csv restaurants.csv
ENTRYPOINT ["java","-jar","/attraction.jar"]