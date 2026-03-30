FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/*.jar app.jar

# Render usa la variable de entorno PORT
EXPOSE ${PORT:-8080}

# Le decimos a Spring Boot que use el puerto que Render nos da
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]
