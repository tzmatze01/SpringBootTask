# image to build app
FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR application
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract


# image to serve app
FROM eclipse-temurin:17-jre-alpine

ENV environment dev

# declare user with restricted privileges to run app
RUN addgroup -S demo && adduser -S demo -G demo
USER demo

VOLUME /tmp
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./

ENTRYPOINT ["java", "-Dspring.profiles.active=${environment}", "org.springframework.boot.loader.JarLauncher"]


## set Profiles SpringApplication.setAdditionalProfiles("dev");
# https://www.baeldung.com/spring-profiles
# create specific application-{profile}.properties

# https://spring.io/guides/topicals/spring-boot-docker/
#  docker run -p 9000:9000 myorg/myapp --server.port=9000

# spring contect indexer
# https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-scanning-index