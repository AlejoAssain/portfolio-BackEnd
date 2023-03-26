FROM amazoncorretto:17-alpine-jdk
MAINTAINER alejo
COPY target/portfolio-argprog-be-0.0.1-SNAPSHOT.jar portfolio-argprog-be.jar
ENTRYPOINT ["java","-jar","/portfolio-argprog-be.jar"]
