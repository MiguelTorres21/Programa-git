package com.migueltorres.tareas;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private Task mapRow(ResultSet rs) throws SQLException {
        return new Task(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("due_date") != null ? LocalDate.parse(rs.getString("due_date")) : null,
                Task.Priority.valueOf(rs.getString("priority")),
                rs.getInt("done") == 1
        );
    }

    public int create(Task task) {
        String sql = "INSERT INTO tasks(title, description, due_date, priority, done) VALUES(?,?,?,?,?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getDueDate() != null ? task.getDueDate().toString() : null);
            ps.setString(4, task.getPriority().name());
            ps.setInt(5, task.isDone() ? 1 : 0);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    task.setId(id);
                    return id;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la tarea", e);
        }
        return -1;
    }

    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM tasks ORDER BY created_at DESC";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar tareas", e);
        }
        return list;
    }

    public boolean update(Task task) {
        String sql = "UPDATE tasks SET title=?, description=?, due_date=?, priority=?, done=? WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getDueDate() != null ? task.getDueDate().toString() : null);
            ps.setString(4, task.getPriority().name());
            ps.setInt(5, task.isDone() ? 1 : 0);
            ps.setInt(6, task.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la tarea", e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM tasks WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la tarea", e);
        }
    }
}
