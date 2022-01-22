package com.alkemy.challenge.challenge.mapper;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {
    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto){
        PeliculaEntity peliculaEntity=new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaDeCreacion(dto.getFechaDeCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());
        return peliculaEntity;
    }
    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity peliculaEntity){
        PeliculaDTO peliculaDTO= new PeliculaDTO();
        peliculaDTO.setId(peliculaEntity.getId());
        peliculaDTO.setImagen(peliculaEntity.getImagen());
        peliculaDTO.setTitulo(peliculaEntity.getTitulo());
        peliculaDTO.setFechaDeCreacion(peliculaEntity.getFechaDeCreacion());
        peliculaDTO.setCalificacion(peliculaEntity.getCalificacion());
        peliculaDTO.setGeneroId(peliculaEntity.getGeneroId());
        return peliculaDTO;
    }
    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity>entities){
        List<PeliculaDTO>dtos=new ArrayList<>();
        for(PeliculaEntity entity:entities){
            dtos.add(this.peliculaEntity2DTO(entity));
        }
        return dtos;
    }
}
