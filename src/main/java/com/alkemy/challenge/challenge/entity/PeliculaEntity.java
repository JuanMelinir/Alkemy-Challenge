package com.alkemy.challenge.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(name="fecha_de_creacion", nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaDeCreacion;

    private int calificacion;

    @ManyToMany(mappedBy = "peliculas", cascade = CascadeType.ALL)
    private List<PersonajeEntity> personajes=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

}
