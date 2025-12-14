package com.migueltorres.tareas;

import java.time.LocalDate;

public class Task {
    public enum Priority { BAJA, MEDIA, ALTA }

    private Integer id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private boolean done;

    public Task(Integer id, String title, String description, LocalDate dueDate, Priority priority, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.done = done;
    }

    public Task(String title, String description, LocalDate dueDate, Priority priority) {
        this(null, title, description, dueDate, priority, false);
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s) - %s - %s",
                id, title, priority, dueDate, done ? "Completada" : "Pendiente");
    }
}
