# Mediscreen Patient Assessment
## Technical:

1. Framework: Spring Boot v2.6.3
2. Project Maven
3. Java 11
4. Spring Data JPA
5. MySQL Driver
6. Spring Web
7. OpenFeign
8. Lombok
9. JaCoCo
10. SureFire
11. Validation
12. Swagger

## Setup MySQL for local testing
1. Change the "DataSource Configuration" in file src/main/resources/application.properties.
2. The database "mediscreen_patient" should have been created with the MediscreenPatient project.

## Use
1. The service address is http://localhost:8080.
2. The Swagger documentation for the API is available at the adress http://localhost:8080/swagger-ui.html.

## Docker service
1. After importing all services (patient, history, assessment and Web UI), run the command "docker-compose up --build" from the folder of the MediscreenPatient project.
2. The Web UI address is http://localhost:8083.
