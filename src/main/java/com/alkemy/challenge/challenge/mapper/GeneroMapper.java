package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {
    public GeneroEntity generoDTO2Entity(GeneroDTO dto){
    GeneroEntity generoEntity=new GeneroEntity();
    generoEntity.setImagen(dto.getImagen());
    generoEntity.setNombre(dto.getNombre());
    return generoEntity;
    }
    public GeneroDTO generoEntity2DTO(GeneroEntity generoEntity){
    GeneroDTO generoDTO= new GeneroDTO();
    generoDTO.setId(generoEntity.getId());
    generoDTO.setImagen(generoEntity.getImagen());
    generoDTO.setNombre(generoEntity.getNombre());
    return generoDTO;
    }

    public List<GeneroDTO> generoEntityList2DTOList(List<GeneroEntity>entities){
    List<GeneroDTO>dtos=new ArrayList<>();
    for(GeneroEntity entity:entities){
    dtos.add(this.generoEntity2DTO(entity));
    }
    return dtos;
    }
}
