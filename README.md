# Drive-in cinema service
<details>
  <summary>Short Description</summary>
    Project implementation of the logic of the internal structure for the service of the open-air cinema. Has the ability to display information about active movies and sessions. Also has the ability to buy tickets, view user history and user registration.
Technologies used:
Java, Hibernate, Spring.
</details>

<details>
  <summary>Full Description</summary>
# Drive-in cinema service
Implementation of an online store with default functionality written in Java.

## Structure

##### The project has an N-tier structure and consists of the layers:
* Database layer;
* DAO layer (JDBC API);
* Service layer(contains the business logic);
* Layer with controllers.

##### Client functions:

* Registration
* Log in system;
* Look active events
* Buy ticket to event
* Lock history of tickets

##### Admin function:

* Take information about user
* Add new information in database LIKE: new Movie, new Session e.t.c
* Modify exist sessions.

## Technologies

* Java 11
* Maven 3.1.1
* Maven Checkstyle Plugin
* Hibernate
* MySQL
* Javax Servlet API
* Spring Framework
* Spring MVC
* Spring Security
* Apache Tomcat

## To start the project you need:

1. Download and install the JDK
2. Download and install web-server (for example Apache Tomcat)
3. Download and install MySQL. Setup connection properties in **db.properties** file
* user: "your username"
* password: "your password"
* db.url=jdbc:mysql://localhost/*your_db_name*?serverTimezone=EET
4. Run a project
</details>
