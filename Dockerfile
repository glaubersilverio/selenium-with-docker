FROM adoptopenjdk/openjdk11:jdk-11.0.11_9
WORKDIR /app
COPY ./target/selenium-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "selenium-0.0.1-SNAPSHOT.jar"]