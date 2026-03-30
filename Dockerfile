FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia el JAR
COPY target/*.jar app.jar

# Render usa la variable PORT
EXPOSE ${PORT:-8080}

# Ejecuta Spring Boot usando el puerto de Render
CMD ["java", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]
