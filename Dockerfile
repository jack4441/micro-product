FROM eclipse-temurin:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bootcamp.product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/bootcamp.product-0.0.1-SNAPSHOT.jar"]