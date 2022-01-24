package com.alkemy.challenge.challenge.mapper;



import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonajeMapper {
    @Autowired
    private PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        PersonajeEntity personajeEntity=new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }
    public PersonajeDTO personajeEntity2DTO(PersonajeEntity personajeEntity,boolean loadPeliculas){
        PersonajeDTO personajeDTO= new PersonajeDTO();
        personajeDTO.setId(personajeEntity.getId());
        personajeDTO.setImagen(personajeEntity.getImagen());
        personajeDTO.setNombre(personajeEntity.getNombre());
        personajeDTO.setEdad(personajeEntity.getEdad());
        personajeDTO.setPeso(personajeEntity.getPeso());
        if(loadPeliculas){
        List<PeliculaDTO>peliculasDTO=peliculaMapper.peliculaEntityList2DTOList(personajeEntity.getPeliculas(),false);
        personajeDTO.setPeliculas(peliculasDTO);
        }
        return personajeDTO;
    }
    public List<PersonajeDTO> personajeEntitySet2DTOList(Collection<PersonajeEntity> entities,boolean loadPeliculas){
        List<PersonajeDTO>dtos=new ArrayList<>();
        for(PersonajeEntity entity:entities){
            dtos.add(this.personajeEntity2DTO(entity,loadPeliculas));
        }
        return dtos;
    }
    public Set<PersonajeEntity> personajeDTOList2Entity(List<PersonajeDTO>dtos){
        Set<PersonajeEntity> entities=new HashSet<>();
        for(PersonajeDTO dto:dtos){
            entities.add(this.personajeDTO2Entity(dto));
        }
        return entities;
    }

}

