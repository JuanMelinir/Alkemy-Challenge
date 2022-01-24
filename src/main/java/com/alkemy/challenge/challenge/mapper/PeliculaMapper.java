package com.alkemy.challenge.challenge.mapper;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {
    private PersonajeMapper personajeMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        PeliculaEntity peliculaEntity=new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());
        Set<PersonajeEntity>personajeEntities=personajeMapper.personajeDTOList2Entity(dto.getPersonajes());
        peliculaEntity.setPersonajes(personajeEntities);
        return peliculaEntity;
    }
    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity peliculaEntity, boolean loadPersonajes){
        PeliculaDTO peliculaDTO= new PeliculaDTO();
        peliculaDTO.setId(peliculaEntity.getId());
        peliculaDTO.setImagen(peliculaEntity.getImagen());
        peliculaDTO.setTitulo(peliculaEntity.getTitulo());
        peliculaDTO.setFechaDeCreacion(peliculaEntity.getFechaDeCreacion());
        peliculaDTO.setCalificacion(peliculaEntity.getCalificacion());
        peliculaDTO.setGeneroId(peliculaEntity.getGeneroId());
        if(loadPersonajes){
        List<PersonajeDTO>personajes=personajeMapper.personajeEntitySet2DTOList(peliculaEntity.getPersonajes(),false);
        peliculaDTO.setPersonajes(personajes);
        }
        return peliculaDTO;
    }
    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity>entities, boolean loadPersonajes){
        List<PeliculaDTO>dtos=new ArrayList<>();
        for(PeliculaEntity entity:entities){
            dtos.add(this.peliculaEntity2DTO(entity,loadPersonajes));
        }
        return dtos;
    }
}
