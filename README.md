# enoca Backend Challenge
# Technologies Used

The project utilizes the following technologies and dependencies:

- [Java](https://www.java.com/) - Programming language.
- [Maven](https://maven.apache.org/) - Build and dependency management tool.
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java applications.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Part of the Spring Data project for JPA-based data access.
- [Spring Web](https://spring.io/projects/spring-framework) - Part of the Spring Framework for building web applications.
- [PostgreSQL](https://www.postgresql.org/) - Open-source relational database management system.
- [Lombok](https://projectlombok.org/) - Library for reducing boilerplate code.
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools) - Development tools for enhancing productivity during development.
- [Swagger UI](https://springdoc.org/) - Tool for API documentation and testing.

### Run Project
#### Clone the repository 
``` 
git clone https://github.com/seppacar/enoca-challenge-q6-spring.git
```
#### Navigate to Project Directory: Change your working directory to the project's root folder.
```
cd yourproject

```
#### Configure Database
Create database
```
createdb enoca_demo
```
#### Database Configuration:
* Provide the necessary database connection details in projects configuration file.

```
src\main\resources\application.properties.yml
```
Ensure that the
```
spring.datasource.url
spring.datasource.username
spring.datasource.password
```
properties are correctly set.

#### Seed the database
* There is a `seed.sql` file under `src\resources`
to seed the database using the psql command-line utility run:
```
psql -U yourusername -d enoca_demo -a -f src/main/resources/seed.sql
```
* Replace yourusername with your PostgreSQL username and adjust the path to the seed.sql file if necessary.

#### Build the project
```
./mvnw clean install
```
* or if you have Maven installed globally
```
mvn clean install
```
#### Run the application
```
java -jar target/enoca-challenge-q6-spring-0.0.1-SNAPSHOT.jar
```

* Server will be running at localhost:8080

### Access Swagger UI

Access the Swagger UI at localhost:8080/swagger-ui/index.html (replace the port if necessary) to explore and test APIs.
