package com.nacho.inmuebles.service;

import com.nacho.inmuebles.persistence.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario update(Long id, Usuario usuario);
    void delete(Long id);
    void delete(Usuario usuario);
    Usuario findById(Long id);
    List<Usuario> findAll();
    List<Usuario> buscarPorNombre(String nombre);
    Usuario findByEmail(String email);
}
