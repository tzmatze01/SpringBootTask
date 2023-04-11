FROM jetty:9.4.51-jre17-alpine-eclipse-temurin

COPY target/application.jar /var/lib/jetty/webapps/application.jar

ENTRYPOINT ["sh", "-c", "java -jar /var/lib/jetty/webapps/appllication.jar"]