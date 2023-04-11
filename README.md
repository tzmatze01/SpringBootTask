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

--- 

#### Request

List of all Users

``
GET  /user/
``

#### Response

```
Status 200
[
    {
        "id": 1,
        "name": "Peter",
        "surname": "Jung",
        "email": "peter123@web.de"
    },
    {
        "id": 2,
        "name": "Angela",
        "surname": "Merkel",
        "email": "angelo@merte.de"
    },
    ...
]
```

--- 

#### Request

List of all Users with a specific name

``
GET  /user/{name}
``

#### Response

```
Status 200
[
   {
        "id": 1,
        "name": "Peter",
        "surname": "Jung",
        "email": "peter123@web.de"
    },
    {
        "id": 3,
        "name": "Peter",
        "surname": "Müller",
        "email": "pemü@gmail.com"
    },
    ...
]
```

--- 

#### Request

Delete a User by Id

``
DELETE  /user/{id}
``

#### Response

```
Status 204
```

--- 
#### Request

Update a User by Id

```
PATCH  /user/{id}
{
    "name": "Hans",
    "surname": "peter",
    "email": "hansp@web.de"
}
```

#### Response 

```
Status 200
{
    "id": {id}, 
    "name": "Hans",
    "surname": "peter",
    "email": "hansp@web.de"
}
```

--- 

#### Request

Create a User 

```
POST  /user/
{
    "name": "Hans",
    "surname": "peter",
    "email": "hansp@web.de"
}
```

#### Response

```
Status 201
{
    "id": 11, 
    "name": "Hans",
    "surname": "peter",
    "email": "hansp@web.de"
}
```

### Problems

* The Jetty Server was not user, because the Jakarta dependecy would [have been downgraded](https://stackoverflow.com/questions/74946784/java-lang-classnotfoundexception-jakarta-servlet-http-httpsessioncontext-with-s) and therefore not be the latest version (`6.0.0 -> 5.0.0`) 
* Could not find a proper source / repository for the `spring-boot-starter-validation`, because it has [been removed](https://stackoverflow.com/questions/62711019/javax-validation-not-found-in-spring-boot-2-3) since `2.3.0`. Therefore `@Validator` decorators could not be imported. 

