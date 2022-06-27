FROM openjdk:17-oracle
COPY build/libs/* ./server.jar
CMD ["java", "-jar", "server.jar", \
    "-Xloggc:gc.log", "-XX:+PrintGCDetails", \
    "-XX:+PrintTenuringDistribution", "-XX:+PrintGCTimeStamps", "-XX:+PrintGcDateStamps"]