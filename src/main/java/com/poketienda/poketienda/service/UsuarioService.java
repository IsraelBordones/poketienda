package com.poketienda.poketienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poketienda.poketienda.model.Usuario;
import com.poketienda.poketienda.repository.UsuarioRepository;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Obtener todos los usuarios
    public List<Usuario> getUsuarios1() {
        return usuarioRepository.findAll();
    }

    // Obtener usuarios activos
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findByActivoTrue();
    }

    // Guardar un nuevo usuario
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener usuario por ID
    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Actualizar usuario existente
    public Usuario updateUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(usuario.getId()).orElseThrow();

        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setActivo(usuario.getActivo()); // Necesario ?
 
        return usuarioRepository.save(usuarioExistente);
    }

    // Eliminación lógica (desactivar usuario)
    public String desactivarUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        
        usuario.setActivo(false);
        usuarioRepository.save(usuario);
        return "Usuario desactivado";
    }

}
