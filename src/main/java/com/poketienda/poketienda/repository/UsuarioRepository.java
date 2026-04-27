package com.poketienda.poketienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poketienda.poketienda.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByActivoTrue();
}
