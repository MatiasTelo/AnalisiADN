FROM ubuntu:latest AS build

# Actualizar e instalar JDK 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Crear un directorio de trabajo
WORKDIR /app

# Copiar todos los archivos del proyecto al contenedor
COPY . .

# Otorgar permisos de ejecución a gradlew
RUN chmod +x ./gradlew

# Construir el JAR
RUN ./gradlew bootJar --no-daemon

# Segunda etapa: imagen más ligera para ejecutar la app
FROM openjdk:17-jdk-slim

# Crear un directorio de trabajo
WORKDIR /app

# Exponer el puerto 2524
EXPOSE 2524

# Copiar el archivo JAR generado desde la etapa de compilación
COPY --from=build /app/build/libs/primer-parcial-0.0.1-SNAPSHOT.jar ./app.jar

# Comando de inicio
ENTRYPOINT ["java", "-jar", "./app.jar"]