FROM openjdk:11-jdk-slim
WORKDIR /app
ADD target/*.jar configurations.jar
COPY . /app
EXPOSE 8080
CMD ["java","-jar","configurations.jar"]