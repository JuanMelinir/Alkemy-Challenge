package com.alkemy.challenge.challenge.mapper;



import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PersonajeMapper {
    @Autowired
    private PeliculaMapper peliculaMapper;

    public Personaje personajeDTO2Entity(PersonajeDTO dto){
        Personaje personaje =new Personaje();
        personaje.setImagen(dto.getImagen());
        personaje.setNombre(dto.getNombre());
        personaje.setEdad(dto.getEdad());
        personaje.setPeso(dto.getPeso());
        personaje.setHistoria(dto.getHistoria());
        return personaje;
    }
    public PersonajeDTO personajeEntity2DTO(Personaje personaje, boolean loadPeliculas){
        PersonajeDTO personajeDTO= new PersonajeDTO();
        personajeDTO.setId(personaje.getId());
        personajeDTO.setImagen(personaje.getImagen());
        personajeDTO.setNombre(personaje.getNombre());
        personajeDTO.setEdad(personaje.getEdad());
        personajeDTO.setPeso(personaje.getPeso());
        if(loadPeliculas){
        List<PeliculaDTO>peliculasDTO=peliculaMapper.peliculaEntityList2DTOList(personaje.getPeliculas(),false);
        personajeDTO.setPeliculas(peliculasDTO);
        }
        return personajeDTO;
    }
    public List<PersonajeDTO> personajeEntitySet2DTOList(Collection<Personaje> entities, boolean loadPeliculas){
        List<PersonajeDTO>dtos=new ArrayList<>();
        for(Personaje entity:entities){
            dtos.add(this.personajeEntity2DTO(entity,loadPeliculas));
        }
        return dtos;
    }
    public Set<Personaje> personajeDTOList2Entity(List<PersonajeDTO>dtos){
        Set<Personaje> entities=new HashSet<>();
        for(PersonajeDTO dto:dtos){
            entities.add(this.personajeDTO2Entity(dto));
        }
        return entities;

    }

}

