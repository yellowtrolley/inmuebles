package com.nacho.inmuebles.persistence.repository;

import com.nacho.inmuebles.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombreLike(String nombre);
    Usuario findByEmail(String email);
    boolean existsByEmail(String email);
}
