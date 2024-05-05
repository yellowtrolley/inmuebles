package com.nacho.inmuebles.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "Email es obligatorio")
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    private Direccion direccion;
}
