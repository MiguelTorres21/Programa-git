# GA7-220501096-AA5-EV01
## Diseño y desarrollo de servicios web – Caso de autenticación

### Aprendiz
Miguel Torres

### Programa
Análisis y Desarrollo de Software – SENA

### Evidencia
GA7-220501096-AA5-EV01

---

## Descripción del proyecto

Este proyecto corresponde al desarrollo de un **servicio web de autenticación** que permite el **registro de usuarios** y el **inicio de sesión**, aplicando los conceptos vistos en el componente formativo **“Construcción de API”**.

El servicio recibe un **usuario y una contraseña** y valida la autenticación, retornando un mensaje de éxito o error según corresponda.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Base de datos H2 (en memoria)
- Maven
- Git / GitHub

---

## Endpoints del servicio

### Registro de usuario
**POST** `/auth/register`

Ejemplo de JSON:
```json
{
  "username": "miguel",
  "password": "123456"
}
```

### Login de usuario
**POST** `/auth/login`

Ejemplo de JSON:
```json
{
  "username": "miguel",
  "password": "123456"
}
```

---
### Ejecucion del proyecto
**1** Abrir la carpeta del proyecto

**2** Ejecutar el comando: `mvnd spring-boot:run`

**3** El servicio quedará disponible en: `http://localhost:8080`



