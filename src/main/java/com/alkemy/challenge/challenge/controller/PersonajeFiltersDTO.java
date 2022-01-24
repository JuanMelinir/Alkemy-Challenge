package com.alkemy.challenge.challenge.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class PersonajeFiltersDTO {
    private String nombre;
    private String edad;
    private Set<Long> peliculas;
    public String order;
    public PersonajeFiltersDTO(String nombre,String edad,Set<Long>peliculas,String order){
    this.nombre=nombre;
    this.edad=edad;
    this.peliculas=peliculas;
    this.order=order;
    }
    public boolean isASC(){return this.order.compareToIgnoreCase("ASC")==0;}
    public boolean isDESC(){return this.order.compareToIgnoreCase("DESC")==0;}
}
