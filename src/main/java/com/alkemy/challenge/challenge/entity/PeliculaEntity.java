package com.alkemy.challenge.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

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

    private Long edad;

    @Column(name="fecha_de_creacion", nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDeCreacion;

    private Long calificacion;

    //trae la informacion del genero
    @ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "genero_id",insertable = false, updatable = false)
    private GeneroEntity genero;
    //guarda y actualiza
    @Column(name = "genero_id",nullable = false)
    private Long generoId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name= "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Set<PersonajeEntity> personajes = new HashSet<>();




}
