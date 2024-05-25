# Folosește o imagine de bază cu JDK 22
FROM openjdk:22-slim

# Setează directorul de lucru în container
WORKDIR /app

# Copiază JAR-ul aplicației în container
COPY target/app.jar app.jar

# Expune portul pe care rulează aplicația
EXPOSE 8081

# Definește comanda de rulare a aplicației
ENTRYPOINT ["java", "-jar", "app.jar"]
