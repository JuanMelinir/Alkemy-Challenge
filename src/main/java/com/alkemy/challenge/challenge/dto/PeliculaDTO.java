package com.alkemy.challenge.challenge.dto;

import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {
    private Long id;

    private String imagen;

    private String titulo;

    private LocalDate fechaDeCreacion;

    private Long calificacion;

    private Long generoId;

    //private Set<PersonajeEntity> personajes = new HashSet<>();

    private List<PersonajeDTO> personajes = new ArrayList<>();

}
