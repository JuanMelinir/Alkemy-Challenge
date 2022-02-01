package com.alkemy.challenge.challenge.mapper;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.Pelicula;
import com.alkemy.challenge.challenge.entity.Personaje;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PeliculaMapper {
    private PersonajeMapper personajeMapper;

    public Pelicula peliculaDTO2Entity(PeliculaDTO dto){
        Pelicula pelicula =new Pelicula();
        pelicula.setImagen(dto.getImagen());
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setFechaDeCreacion(dto.getFechaDeCreacion());
        pelicula.setCalificacion(dto.getCalificacion());
        pelicula.setGenero(dto.getGenero());
        Set<Personaje>personajeEntities=personajeMapper.personajeDTOList2Entity(dto.getPersonajes());
        pelicula.setPersonajes(personajeEntities);
        return pelicula;
    }
    public PeliculaDTO peliculaEntity2DTO(Pelicula pelicula, boolean loadPersonajes){
        PeliculaDTO peliculaDTO= new PeliculaDTO();
        peliculaDTO.setId(pelicula.getId());
        peliculaDTO.setImagen(pelicula.getImagen());
        peliculaDTO.setTitulo(pelicula.getTitulo());
        peliculaDTO.setFechaDeCreacion(pelicula.getFechaDeCreacion());
        peliculaDTO.setCalificacion(pelicula.getCalificacion());
        peliculaDTO.setGenero(pelicula.getGenero());
        if(loadPersonajes){
        List<PersonajeDTO>personajes=personajeMapper.personajeEntitySet2DTOList(pelicula.getPersonajes(),false);
        peliculaDTO.setPersonajes(personajes);
        }
        return peliculaDTO;
    }
    public List<PeliculaDTO> peliculaEntityList2DTOList(List<Pelicula>entities, boolean loadPersonajes){
        /*List<PeliculaDTO>dtos=new ArrayList<>();
        for(Pelicula entity:entities){
            dtos.add(this.peliculaEntity2DTO(entity,loadPersonajes));
        }
        return dtos;*/
        return entities.stream().map(entity-> peliculaEntity2DTO(entity,loadPersonajes)).collect(Collectors.toList());
    }
}
