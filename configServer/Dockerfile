FROM openjdk:11
WORKDIR /app
ADD target/*.jar config-server.jar
COPY . /app
EXPOSE 8081
CMD ["java","-jar","config-server.jar"]