package com.migueltorres.web.repo;

import com.migueltorres.web.model.Task;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRepository {
    private static final List<Task> DATA = new ArrayList<>();
    private static final AtomicInteger SEQ = new AtomicInteger(1);

    static {
        DATA.add(new Task(SEQ.getAndIncrement(), "Ejemplo inicial", "Tarea de ejemplo", LocalDate.now().plusDays(3), Task.Priority.ALTA, false));
    }

    public List<Task> findAll() { return new ArrayList<>(DATA); }

    public List<Task> findFiltered(String q, String status) {
        return DATA.stream()
                .filter(t -> q == null || q.isBlank() || t.getTitle().toLowerCase().contains(q.toLowerCase()))
                .filter(t -> {
                    if (status == null || status.isBlank() || "todos".equalsIgnoreCase(status)) return true;
                    if ("pendientes".equalsIgnoreCase(status)) return !t.isDone();
                    if ("completadas".equalsIgnoreCase(status)) return t.isDone();
                    return true;
                })
                .toList();
    }

    public Task create(Task t) {
        t.setId(SEQ.getAndIncrement());
        DATA.add(t);
        return t;
    }

    public boolean toggle(int id) {
        for (Task t : DATA) {
            if (Objects.equals(t.getId(), id)) {
                t.setDone(!t.isDone());
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return DATA.removeIf(t -> Objects.equals(t.getId(), id));
    }
}
