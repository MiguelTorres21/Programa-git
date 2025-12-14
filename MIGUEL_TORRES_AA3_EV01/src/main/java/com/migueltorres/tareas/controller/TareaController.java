package com.migueltorres.tareas.controller;

import com.migueltorres.tareas.model.Tarea;
import com.migueltorres.tareas.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarea> listar() {
        return service.listar();
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return service.guardar(tarea);
    }
}
