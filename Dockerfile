FROM springci/graalvm-ce:java17-0.11.x as builder
WORKDIR /app
COPY build/libs/* ./server.jar
RUN java -Djarmode=layertools -jar server.jar extract

FROM springci/graalvm-ce:java17-0.11.x
WORKDIR /app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/application/ ./

ENTRYPOINT  ["java", "org.springframework.boot.loader.JarLauncher", \
    "-Xloggc:gc.log", "-XX:+PrintGCDetails", \
    "-XX:+PrintTenuringDistribution", "-XX:+PrintGCTimeStamps", "-XX:+PrintGcDateStamps"]