# image to build app
FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR application
COPY target/application.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract


# image to serve app
FROM eclipse-temurin:17-jre-alpine

# declare user with restricted privileges to run app
RUN addgroup -S demo && adduser -S demo -G demo
USER demo

VOLUME /tmp
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
