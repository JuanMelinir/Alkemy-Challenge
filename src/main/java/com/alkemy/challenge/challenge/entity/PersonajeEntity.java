package com.alkemy.challenge.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    //trae la informacion de la pelicula
    @ManyToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "peliculas_id", insertable = false, updatable = false)
    private PeliculaEntity pelicula;
    //guarda y actualiza
    @Column(name= "pelicula_id", nullable = false)
    private Long peliculaId;

    @ManyToMany(
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
              })

    @JoinTable(
            name = "personaje_pelicula",
            joinColumns = @JoinColumn(name= "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private Set<PeliculaEntity> peliculas = new HashSet<>();

}
