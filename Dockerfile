# Etapa de Build - Usa Maven oficial (no depende de tu wrapper)
FROM maven:3.9.9-eclipse-temurin-17-alpine AS builder
WORKDIR /app

# Copiar pom.xml primero (mejora el cache de dependencias)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src src

# Compilar el proyecto
RUN mvn clean package -DskipTests

# Etapa Runtime - Imagen muy ligera
FROM eclipse-temurin:17-jre-alpine-3.23
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]