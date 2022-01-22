package com.alkemy.challenge.challenge.mapper;



import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {
    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto){
        PersonajeEntity personajeEntity=new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }
    public PersonajeDTO personajeEntity2DTO(PersonajeEntity personajeEntity){
        PersonajeDTO personajeDTO= new PersonajeDTO();
        personajeDTO.setId(personajeEntity.getId());
        personajeDTO.setImagen(personajeEntity.getImagen());
        personajeDTO.setNombre(personajeEntity.getNombre());
        personajeDTO.setEdad(personajeEntity.getEdad());
        personajeDTO.setPeso(personajeEntity.getPeso());
        return personajeDTO;
    }
    public List<PersonajeDTO> personajeEntityList2DTOList(List<PersonajeEntity>entities){
        List<PersonajeDTO>dtos=new ArrayList<>();
        for(PersonajeEntity entity:entities){
            dtos.add(this.personajeEntity2DTO(entity));
        }
        return dtos;
    }
}
