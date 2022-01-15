package com.alkemy.challenge.challenge.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="genero")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    @OneToMany
    @JoinColumn(name = "pelicula_id")
    private PeliculaEntity pelicula;
}