package com.alkemy.challenge.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pelicula")
@Getter
@Setter

public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    private int edad;

    @Column(name="fecha_de_creacion")
    private Date fechaDeCreacion;

    private int calificacion;

    @ManyToMany
    @JoinColumn(name = "personaje_id")
    private PersonajeEntity personaje;

    @OneToOne
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

}
