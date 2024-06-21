# Epic Travel Assistant REST API

This Spring Boot application provides a REST API with endpoints to retrieve city information and manage user registration and authentication.

## Overview

The application retrieves information such as weather data, exchange rate data, population, and GDP per capita data based on user requests.

## Endpoints

1. **City API**

    - Endpoint: `http://localhost:8081/api/v1/city?name=<city>`
    - Description: Retrieves a list of cities based on the name provided in the request parameter.

2. **User Registration**

    - Endpoint: `/api/v1/user/register`
    - Method: `POST`
    - Description: Registers a new user using the data provided in the request body.

3. **User Sign In**

    - Endpoint: `/api/v1/user/login`
    - Method: `POST`
    - Description: Authenticates a user based on the credentials provided in the request body.

## Installation and Usage

### Prerequisites

- Java 8 or higher
- Gradle

### Running Locally

1. Clone the repository then:
   `cd <repository-name>`

2. Build and run the application using Gradle:
 `/gradlew bootRun`


The application will start on `localhost:8081`.

3. Access the API endpoints:

- City API: `http://localhost:8081/api/v1/city?name=<city>`
- User Registration: `http://localhost:8081/api/v1/user/register`
- User Sign In: `http://localhost:8081/ap1/v1/user/login`

### Building and Running as a JAR

1. Build the JAR by runing the `bootjar` command
2. Run the JAR file:`java -jar build/libs/epictravelassistant-0.0.1-SNAPSHOT.jar`

### Docker

1. Build the Docker image: `docker build -t <image-name> .`
2. Run the Docker container:`docker run -p 8081:8081 <image-name>`
   
 ## Usage:

- City API: `http://localhost:8080/v1/city/name`
- User Registration: `http://localhost:8080/v1/user/register`
- User Sign In: `http://localhost:8080/v1/user/signIn`

## Features

- [x] Querying city data
- [ ] Rate limiting (not achieved)
- [ ] Caching  (was set up but minimally achieved)
- [x] Authentication 
