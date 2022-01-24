package com.alkemy.challenge.challenge.service.impl;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.entity.Pelicula;
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
        Pelicula pelicula =peliculaMapper.peliculaDTO2Entity(dto);
        Pelicula peliculaSaved =peliculaRepository.save(pelicula);
        PeliculaDTO result= peliculaMapper.peliculaEntity2DTO(peliculaSaved,false);
        //todo: guardar pelicula
        System.out.println("GUARDAR PELICULA");
        return result;
    }

    public List<PeliculaDTO> getAllPeliculas() {
        List<Pelicula>peliculas=peliculaRepository.findAll();
        List<PeliculaDTO> result=peliculaMapper.peliculaEntityList2DTOList(peliculas,false);
        return result;
    }
    public void delete(Long id){
        peliculaRepository.deleteById(id);
    }

    public Pelicula getEntityById(Long id){
    Pelicula pelicula=peliculaRepository.getById(id);
    return pelicula;
    }
}
