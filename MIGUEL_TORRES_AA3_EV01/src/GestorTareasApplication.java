package com.migueltorres.tareas.service;

import com.migueltorres.tareas.model.Tarea;
import com.migueltorres.tareas.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository repo;

    public TareaService(TareaRepository repo) {
        this.repo = repo;
    }

    public List<Tarea> listar() {
        return repo.findAll();
    }

    public Tarea guardar(Tarea tarea) {
        return repo.save(tarea);
    }

    public Tarea obtener(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Tarea cambiarEstado(Long id, boolean estado) {
        Tarea t = obtener(id);
        t.setCompletada(estado);
        return repo.save(t);
    }
}
