package com.migueltorres.web.servlet;

import com.migueltorres.web.model.Task;
import com.migueltorres.web.repo.TaskRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "TaskServlet", urlPatterns = {"/tasks"})
public class TaskServlet extends HttpServlet {

    private final TaskRepository repo = new TaskRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        String status = req.getParameter("status");
        List<Task> tasks = repo.findFiltered(q, status);
        req.setAttribute("tasks", tasks);
        req.setAttribute("q", q);
        req.setAttribute("status", status == null ? "todos" : status);
        req.getRequestDispatcher("/WEB-INF/views/tasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            String due = req.getParameter("dueDate");
            String priority = req.getParameter("priority");
            Task t = new Task(
                    title,
                    description,
                    (due == null || due.isBlank()) ? null : LocalDate.parse(due),
                    priority == null ? Task.Priority.MEDIA : Task.Priority.valueOf(priority)
            );
            repo.create(t);

        } else if ("toggle".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            repo.toggle(id);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            repo.delete(id);
        }

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }
}
