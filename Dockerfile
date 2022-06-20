FROM openjdk:17-oracle
COPY build/libs/* ./server.jar
CMD ["java", "-jar", "server.jar"]