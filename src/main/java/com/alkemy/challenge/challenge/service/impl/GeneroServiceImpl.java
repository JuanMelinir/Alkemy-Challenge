package com.alkemy.challenge.challenge.service.impl;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.entity.Genero;
import com.alkemy.challenge.challenge.mapper.GeneroMapper;
import com.alkemy.challenge.challenge.repository.GeneroRepository;
import com.alkemy.challenge.challenge.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save(GeneroDTO dto){
        Genero genero =generoMapper.generoDTO2Entity(dto);
        Genero generoSaved =generoRepository.save(genero);
        GeneroDTO result= generoMapper.generoEntity2DTO(generoSaved);
    //todo: guardar genero
        System.out.println("GUARDAR GENERO");
        return result;
    }
    public List<GeneroDTO> getAllGeneros() {
        List<Genero>generos=generoRepository.findAll();
        List<GeneroDTO> result=generoMapper.generoEntityList2DTOList(generos);
        return result;
    }
    public void delete(Long id){
    generoRepository.deleteById(id);
    }

}
