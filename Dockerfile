FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE ${PORT:-8080}

# Configuración para Render + desactivar temporalmente JPA si la BD no está lista
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8080}",  "-Dspring.profiles.active=prod", "-Dspring.jpa.hibernate.ddl-auto=none", "-jar", "app.jar"]
