FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia el JAR generado (con wildcard más seguro)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
