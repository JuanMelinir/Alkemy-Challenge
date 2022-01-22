package com.alkemy.challenge.challenge.service.impl;


import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import com.alkemy.challenge.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.challenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDTO save(PersonajeDTO dto){
        PersonajeEntity personajeEntity=personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity personajeEntitySaved=personajeRepository.save(personajeEntity);
        PersonajeDTO result= personajeMapper.personajeEntity2DTO(personajeEntitySaved);
        //todo: guardar genero
        System.out.println("GUARDAR PERSONAJE");
        return result;
    }


    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeEntity>personajes=personajeRepository.findAll();
        List<PersonajeDTO> result=personajeMapper.personajeEntityList2DTOList(personajes);
        return result;
    }
    public void delete(Long id){
        personajeRepository.deleteById(id);
    }
}
