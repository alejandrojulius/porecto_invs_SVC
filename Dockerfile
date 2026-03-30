# ==================== ETAPA 1: Construcción ====================
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Copiar archivos de Maven
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Dar permisos al wrapper
RUN chmod +x ./mvnw

# Descargar dependencias (cache)
RUN ./mvnw dependency:go-offline -B --no-transfer-progress

# Copiar código fuente
COPY src ./src

# Construir la aplicación
RUN ./mvnw clean package -DskipTests --no-transfer-progress

# ==================== ETAPA 2: Imagen final ====================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE ${PORT:-8080}

# Usar la variable PORT que Render proporciona
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]