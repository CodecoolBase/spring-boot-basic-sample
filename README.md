# Example code for Sping Boot applications

## Showcase

The following Spring features are included:
* injection and scoping
* component and service beans
* persistence (JPA) and repository interfaces
* basic web UI (MVC with Thymeleaf)
* basic RestFUL interface

The codebase is built by Spring Boot, no installation or further configuration is needed.

## Instructions

1. Clone repository as a Maven project.
1. Copy `project-defaults.yml.example` to `project-defaults.yml` and configure your database connection.
1. Start with `SpringBootBasicSampleApplication`'s `main`.

## Structure

* `pom.xml`: you can see the Spring Boot dependencies commented there.
* `src/main/resources/`: `application.properties` is _Spring Boot_'s settings file
  * in `static` you can find the static web resources
  * in `templates` are the Thymeleaf template files
* `src/main/java/`: holds the code
  * the `controller` package is the place for `@Controller` beans
  * the `service` package is for the service layer beans which encapsulate the business logic
    * the `InitializerBean` is an example of a singleton `@Component` responsible for the database initialization
    * `CustomerService` is a service class for `Customer` related request
  * the `repository` package is the DAO layer for managing the model classes
  * the `api` package defines RESTful webservice endpoints
  * the `model` package holds the model classes, in this case JPA `@Entity` classes
  
This structure is not compulsory but can be considered as a typical version of a smaller Spring Boot project.
