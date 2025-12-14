# GA7-220501096-AA3-EV01 - Módulo Spring Boot (Gestor de Tareas)

Framework: Spring Boot (Java 17) + Spring Data JPA + H2.

## Ejecutar
mvnd clean spring-boot:run

## Probar
GET http://localhost:8080/api/tareas
POST http://localhost:8080/api/tareas (JSON)
H2 Console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:tareasdb
