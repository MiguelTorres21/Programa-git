package com.migueltorres.auth.controller;

import com.migueltorres.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controlador de autenticación
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    // Registro
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        service.registrar(body.get("usuario"), body.get("password"));
        return Map.of("mensaje", "Usuario registrado correctamente");
    }

    // Login
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        boolean ok = service.autenticar(body.get("usuario"), body.get("password"));

        if (ok) {
            return Map.of("mensaje", "Autenticación satisfactoria");
        } else {
            return Map.of("error", "Error en la autenticación");
        }
    }
}