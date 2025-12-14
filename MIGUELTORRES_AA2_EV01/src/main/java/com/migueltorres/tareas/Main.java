package com.migueltorres.tareas;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Gestor de Tareas JDBC...");
        Database.initialize();

        TaskDAO dao = new TaskDAO();

        Task nueva = new Task("Estudiar JDBC", "Revisar conexión y CRUD", LocalDate.now().plusDays(2), Task.Priority.ALTA);
        dao.create(nueva);
        System.out.println("Tarea creada: " + nueva);

        List<Task> lista = dao.getAll();
        System.out.println("\nListado de tareas:");
        lista.forEach(System.out::println);
    }
}
