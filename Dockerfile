# ==================== BUILD STAGE ====================
FROM maven:3.9.9-eclipse-temurin-17-alpine AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn clean package -DskipTests

# ==================== RUNTIME STAGE ====================
FROM eclipse-temurin:17-jre-alpine-3.23
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Muy importante para Render
ENV PORT=8080
ENV SERVER_PORT=${PORT}

# Opción recomendada para Render (usa la variable PORT)
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]