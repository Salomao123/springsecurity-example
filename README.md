# Great Hands On Spring Boot REST API with Spring Security + JWT

This is a great hands on at Spring Boot REST API that demonstrates how to implement Spring Security with JWT (JSON Web Token) authentication.

## Features

- User registration and authentication using JWT
- Authorization and role-based access control (RBAC)
- Swagger API documentation for easy exploration and testing
- Customizable authentication and authorization logic
- Built-in MySQL Image Docker database for easy development and testing

## Technologies Used

- Spring Boot
- Spring Security
- JSON Web Token (JWT)
- Spring Data JPA
- MySQL Driver
- Swagger UI

## Prerequisites

- Java 11
- Maven
- Your favorite IDE (IntelliJ, Eclipse, etc.)

## Getting Started

1. Clone the repository: `https://github.com/Salomao123/springsecurity-example.git`
2. Navigate to the project: `cd springsecurity-example`
3. You can run the unit test with: `mvn clean test`
4. Build the project using Maven: `mvn clean install`
5. Navigate to the 'docs' path on the root and run `docker-compose up -d` to handle the database image in docker (in this example I'm using mysql, but fell free to use whatever you want)
6. Connect to the database. In my case, Im using DBeaver to configure mysql
7. Ater that, you've to create the database running this command: `CREATE DATABASE `USER` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;`
8. then, In the same directoy 'docs' you can find a `usuario_202305121134.sql` which already have some user to import into database. As the password will encrypted, the original password is `123` 
9. therefore, you can find collections and environment into 'docs' path as well, fell free to import into postman or insomnia if you want
10. after all, you can run the application with : `mvn spring-boot:run` or in your favorite IDE <3 and the api will be available at http://localhost:8085/api
11. after running, you can access the swagger-ui at http://localhost:8085/api/swagger-ui/index.html#/user-controller

## API Endpoints

The following API endpoints are available:

- `POST /authenticate` - login and JWT generation
- `GET /users` - Get all users
- `GET /users/{id}` - Get user by ID
- `POST /users` - Create a new user


## Configuration

- JWT secret key: Update the secret key used for JWT token signing in the `JwtAuthenticationFilter` class.
- User roles and permissions: Modify the `Role` and `Permission` entities to fit your application's requirements.
- Security configurations: Customize the security configurations in the `SecurityConfig` class according to your needs.

## Documentation

The API is documented using Swagger UI. You can access the Swagger UI page at `http://localhost:8085/api/swagger-ui/index.html#/user-controller` after starting the application.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please create an issue or submit a pull request.

## License

This project is licensed under me. :)



