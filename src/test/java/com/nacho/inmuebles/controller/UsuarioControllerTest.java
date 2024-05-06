package com.nacho.inmuebles.controller;

import com.nacho.inmuebles.persistence.entity.Usuario;
import com.nacho.inmuebles.persistence.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @AfterEach
    public void cleanUp() {
        usuarioRepository.deleteAll();
    }


    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    @Test
    public void whenCreateNewUsuario_thenCreated() throws Exception {
        final Usuario usuario = new Usuario();
        usuario.setNombre("Usuario");
        usuario.setEmail("usuario@email.com");

        mockMvc.perform(
                        post("/usuarios/adduser")
                                .param("nombre", usuario.getNombre())
                                .param("email", usuario.getEmail())
                                .with(csrf())
                )
                .andExpect(status().is3xxRedirection());

        assertTrue(usuarioRepository.existsByEmail(usuario.getEmail()));
    }


}