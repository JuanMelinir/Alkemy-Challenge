package com.alkemy.challenge.challenge.mapper;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entity.Genero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeneroMapper {
    public Genero generoDTO2Entity(GeneroDTO dto){
    Genero genero =new Genero();
    genero.setImagen(dto.getImagen());
    genero.setNombre(dto.getNombre());
    return genero;
    }
    public GeneroDTO generoEntity2DTO(Genero genero){
    GeneroDTO generoDTO= new GeneroDTO();
    generoDTO.setId(genero.getId());
    generoDTO.setImagen(genero.getImagen());
    generoDTO.setNombre(genero.getNombre());
    return generoDTO;
    }

    public List<GeneroDTO> generoEntityList2DTOList(List<Genero>entities){
    /*List<GeneroDTO>dtos=new ArrayList<>();
    for(Genero entity:entities){
    dtos.add(this.generoEntity2DTO(entity));
    }
    return dtos;*/
        return entities.stream().map(entity-> generoEntity2DTO(entity) ).collect(Collectors.toList());
    }
}
