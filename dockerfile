FROM openjdk:8
WORKDIR /usr/src/app
COPY ./target/api-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
