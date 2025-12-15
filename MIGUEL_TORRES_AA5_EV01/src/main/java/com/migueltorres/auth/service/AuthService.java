package com.migueltorres.auth.service;

import com.migueltorres.auth.model.Usuario;
import com.migueltorres.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio de autenticación
 */
@Service
public class AuthService {

    private final UsuarioRepository repository;

    public AuthService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Registro
    public Usuario registrar(String usuario, String password) {
        Usuario nuevo = new Usuario();
        nuevo.setUsuario(usuario);
        nuevo.setPassword(password); //
        return repository.save(nuevo);
    }

    // Login
    public boolean autenticar(String usuario, String password) {
        return repository.findByUsuario(usuario)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}