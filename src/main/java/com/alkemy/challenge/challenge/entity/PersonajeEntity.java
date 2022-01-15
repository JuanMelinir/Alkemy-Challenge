package com.alkemy.challenge.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private int edad;

    private double peso;

    private String historia;

    @ManyToMany
    @JoinColumn(name = "peliculas_id")
    private PeliculaEntity pelicula;

}
