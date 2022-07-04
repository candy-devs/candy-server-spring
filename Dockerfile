FROM graalvm-ce:java17-0.11.x
COPY build/libs/* ./server.jar
CMD ["java", "-jar", "server.jar", \
    "-Xloggc:gc.log", "-XX:+PrintGCDetails", \
    "-XX:+PrintTenuringDistribution", "-XX:+PrintGCTimeStamps", "-XX:+PrintGcDateStamps"]