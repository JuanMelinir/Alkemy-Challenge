package com.alkemy.challenge.challenge.service.impl;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.challenge.mapper.PeliculaMapper;
import com.alkemy.challenge.challenge.repository.PeliculaRepository;
import com.alkemy.challenge.challenge.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDTO save(PeliculaDTO dto){
        PeliculaEntity peliculaEntity=peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity peliculaEntitySaved=peliculaRepository.save(peliculaEntity);
        PeliculaDTO result= peliculaMapper.peliculaEntity2DTO(peliculaEntitySaved,false);
        //todo: guardar pelicula
        System.out.println("GUARDAR PELICULA");
        return result;
    }

    public List<PeliculaDTO> getAllPeliculas() {
        List<PeliculaEntity>peliculas=peliculaRepository.findAll();
        List<PeliculaDTO> result=peliculaMapper.peliculaEntityList2DTOList(peliculas,false);
        return result;
    }
    public void delete(Long id){
        peliculaRepository.deleteById(id);
    }

    public PeliculaEntity getEntityById(Long id){
    PeliculaEntity pelicula=peliculaRepository.getById(id);
    return pelicula;
    }
}
