FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.tourist="beta"
COPY target/auth.jar auth.jar
ENTRYPOINT ["java","-jar","/auth.jar"]