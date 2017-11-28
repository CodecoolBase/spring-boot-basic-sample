# Example code for Sping Boot applications

## Showcase

The following Spring features are included:
* injection and scoping
* component and service beans
* persistence (JPA) and repository interface
* basic web UI (MVC with Thymeleaf)
* basic RestFUL interface

The codebase is built by Spring Boot, no installation or further configuration is needed.

## Instructions

1. Clone repository as a Maven project.
1. Copy `project-defaults.yml.example` to `project-defaults.yml` and configure your database connection.
1. Start with `mvn wildfly-swarm:run`, or in IntelliJ IDEA open the `Maven Projects` menu, and under `Plugins/wildfly-swarm` click `wildfly-swarm:run`.

## Structure

* `pom.xml`: you can see the general Java EE 7 API dependency and the explicit implementation 'fragments' of WildFly
* `src/main/resources/`: `project-defaults.yml` is _WildFly Swarm_'s settings file, in `META-INF/persistence.xml` you can add extra JPA settings
* `src/main/webapp/`: all the view related files are placed here
  * `WEB-INF/web.xml` is the general settings file for servlets (the web part of Java)
  * the `xhtml` files are the view template files for Java Server Faces (JSF)
  * `index.html` and the `resources/` folder are examples of static content
* `src/main/java/`: holds the code
  * the `controller` package is the place for controller (`@RequestScoped` or `@SessionScoped`) beans
  * the `ejb` package is for the Enterprise Java Beans which encapsulate the business logic
    * the `InitializerBean` is an example of a `@Singleton` EJB responsible for the database initialization
    * `AbstractFacade` class is an Oracle standard solution for an abstract CRUD service
    * `CustomerService` (extending the former) is a service class for `Customer` related request (could have been named as `CustomerFacade`, `CustomerManager`, or `CustomerEJB`)
  * the `api` package defines RESTful webservice endpoints
  * the `model` package holds the model classes, in this case JPA `@Entity` classes
  
This structure is not compulsory but can be considered as a typical version of a smaller Java EE project.
