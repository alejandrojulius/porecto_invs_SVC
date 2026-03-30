FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/*.jar app.jar

# Importante para Render: usar la variable PORT que ellos asignan
EXPOSE ${PORT:-8080}

# Spring Boot debe leer el puerto desde la variable de entorno PORT
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]