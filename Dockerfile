FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia el archivo JAR generado
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
