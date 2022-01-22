package com.alkemy.challenge.challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="personaje")
@Getter
@Setter
@SQLDelete(sql="UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause="delete=false")

public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private Long edad;

    private Long peso;

    private String historia;

    private boolean deleted=Boolean.FALSE;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas=new ArrayList<>();

}
