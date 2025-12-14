<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Tareas</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/styles.css'/>">
</head>
<body>
<header>
    <h1>Listado de Tareas</h1>
    <a href="<c:url value='/'/>">Inicio</a>
</header>

<main class="grid">
  <section class="card span-2">
      <form class="form inline" method="get" action="tasks">
          <input type="text" name="q" placeholder="Buscar..." value="${q}">
          <select name="status">
              <option value="todos" ${status == 'todos' ? 'selected' : ''}>Todos</option>
              <option value="pendientes" ${status == 'pendientes' ? 'selected' : ''}>Pendientes</option>
              <option value="completadas" ${status == 'completadas' ? 'selected' : ''}>Completadas</option>
          </select>
          <button type="submit" class="btn small">Filtrar</button>
      </form>
  </section>

  <section class="card span-2">
      <h2>Tareas</h2>
      <table class="table">
          <thead>
              <tr>
                  <th>ID</th><th>Título</th><th>Descripción</th><th>Fecha límite</th><th>Prioridad</th><th>Estado</th><th>Acciones</th>
              </tr>
          </thead>
          <tbody>
              <c:forEach var="task" items="${tasks}">
                  <tr>
                      <td>${task.id}</td>
                      <td>${task.title}</td>
                      <td>${task.description}</td>
                      <td>${task.dueDate}</td>
                      <td>${task.priority}</td>
                      <td>
                          <c:choose>
                              <c:when test="${task.done}">✅</c:when>
                              <c:otherwise>⏳</c:otherwise>
                          </c:choose>
                      </td>
                      <td>
                          <form class="form inline" method="post" action="tasks">
                              <input type="hidden" name="action" value="toggle"/>
                              <input type="hidden" name="id" value="${task.id}"/>
                              <button class="btn small" type="submit">Cambiar</button>
                          </form>
                          <form class="form inline" method="post" action="tasks">
                              <input type="hidden" name="action" value="delete"/>
                              <input type="hidden" name="id" value="${task.id}"/>
                              <button class="btn small danger" type="submit">Eliminar</button>
                          </form>
                      </td>
                  </tr>
              </c:forEach>
          </tbody>
      </table>
  </section>

  <section class="card span-2">
      <h2>Nueva tarea</h2>
      <form class="form" method="post" action="tasks">
          <input type="hidden" name="action" value="create">
          <label>Título: <input type="text" name="title" required></label>
          <label>Descripción: <input type="text" name="description"></label>
          <label>Fecha límite: <input type="date" name="dueDate"></label>
          <label>Prioridad:
              <select name="priority">
                  <option value="ALTA">Alta</option>
                  <option value="MEDIA" selected>Media</option>
                  <option value="BAJA">Baja</option>
              </select>
          </label>
          <button class="btn" type="submit">Guardar</button>
      </form>
  </section>
</main>

<footer><small>© Proyecto Gestor de Tareas - SENA</small></footer>
</body>
</html>
