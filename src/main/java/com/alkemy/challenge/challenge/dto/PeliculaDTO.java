package com.alkemy.challenge.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PeliculaDTO {
    private Long id;

    private String imagen;

    private String titulo;

    private LocalDate fechaDeCreacion;

    private Long calificacion;

    private Long generoId;

    //private Set<Personaje> personajes = new HashSet<>();

    private List<PersonajeDTO> personajes = new ArrayList<>();

}
