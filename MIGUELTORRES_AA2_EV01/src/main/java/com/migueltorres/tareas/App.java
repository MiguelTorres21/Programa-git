package com.migueltorres.tareas;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("== Gestor de Tareas – JDBC (SQLite) ==");

        TaskDAO dao = new TaskDAO();

        Task t1 = new Task("Enviar informe", "Informe mensual de ventas", LocalDate.now().plusDays(3), Task.Priority.ALTA);
        int id1 = dao.createTask(t1);
        System.out.println("Creada: " + t1);

        List<Task> all = dao.getAllTasks();
        System.out.println("Listado inicial (" + all.size() + "): " + all);

        t1.setDone(true);
        t1.setDescription("Informe mensual actualizado");
        dao.updateTask(t1);
        System.out.println("Actualizada: " + dao.getTaskById(id1));

        Task t2 = new Task("Reunión cliente", "Revisión de requerimientos", LocalDate.now().plusDays(7), Task.Priority.MEDIA);
        dao.createTask(t2);
        System.out.println("Creada: " + t2);
        dao.deleteTask(t2.getId());
        System.out.println("Eliminada tarea id=" + t2.getId());

        System.out.println("Listado final: " + dao.getAllTasks());
        System.out.println("BD: db/tareas.db (tabla tasks) – ejecución completa.");
    }
}
