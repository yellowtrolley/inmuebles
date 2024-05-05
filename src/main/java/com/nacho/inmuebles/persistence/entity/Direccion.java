package com.nacho.inmuebles.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String calle;
    private String poblacion;
    private String provincia;
    private Integer cp;

}
