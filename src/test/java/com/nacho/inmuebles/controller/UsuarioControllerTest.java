package com.nacho.inmuebles.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {
    @Autowired
    public MockMvc mockMvc;


    @Test
    public void whenCreateNewUsuario_thenCreated() {
//        final Usuario usuario = new Usuario();
//
//        final Response response = RestAssured.given()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(book)
//                .post(API_ROOT);
//        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

}