FROM openjdk:17-jdk-alpine
LABEL com.maghrebtrip.plan="beta"
COPY target/plan.jar plan.jar
ENTRYPOINT ["java","-jar","/plan.jar"]