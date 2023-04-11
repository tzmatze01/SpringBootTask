## Programming Task with Spring Boot 


### Prequisites 

The app automaticly loads some dummy data to the H2 In-Memory database. The according SQL files for the data and schema are located in `src/main/resources`. 

First a JAR file with your IDE of joice has to be created. For that use the maven CLI command `./mvnw install -DskipTests` or the `install` Lifecycle method of your Maven Plugin in the IDE. 

To launch the app, a container has to be build first.  

```bash 
docker build . --tag demo
```

### Run the app 

When running the app you can choose a Spring Profile with the following parameter for `development`
```bash
docker run -it -e "SPRING_PROFILES_ACTIVE=dev" -p 8000:8000 demo:latest
```

or `production`, with the according ports exposed. 

```bash
docker run -it -e "SPRING_PROFILES_ACTIVE=production" -p 9000:9000 demo:latest
```

### Use the API 

The app implements the following Endpoints. 

