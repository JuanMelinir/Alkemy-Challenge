package com.alkemy.challenge.challenge.service.impl;


import com.alkemy.challenge.challenge.controller.PersonajeFiltersDTO;
import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.GeneroEntity;
import com.alkemy.challenge.challenge.entity.PeliculaEntity;
import com.alkemy.challenge.challenge.entity.PersonajeEntity;
import com.alkemy.challenge.challenge.exception.ParamNotFound;
import com.alkemy.challenge.challenge.mapper.PersonajeMapper;
import com.alkemy.challenge.challenge.repository.PersonajeRepository;
import com.alkemy.challenge.challenge.repository.specifications.PersonajeSpecificacion;
import com.alkemy.challenge.challenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
  public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeSpecificacion personajeSpecificacion;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PeliculaServiceImpl peliculaService;

    public List<PersonajeDTO>getByFilters(String nombre, String edad, Set<Long> peliculas, String order){
        PersonajeFiltersDTO filtersDTO=new PersonajeFiltersDTO(nombre,edad,peliculas,order);
        List<PersonajeEntity>personajes=personajeRepository.findAll(personajeSpecificacion.getByFilters(filtersDTO));
        List<PersonajeDTO>dtos=personajeMapper.personajeEntitySet2DTOList(personajes,true);
        return dtos;
    }
    public PersonajeDTO save(PersonajeDTO dto){
        PersonajeEntity personajeEntity=personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity personajeEntitySaved=personajeRepository.save(personajeEntity);
        PersonajeDTO dtos= personajeMapper.personajeEntity2DTO(personajeEntitySaved,false);
        //todo: guardar genero
        System.out.println("GUARDAR PERSONAJE");
        return dtos;
    }


    public List<PersonajeDTO> getAllPersonajes() {
        List<PersonajeEntity>personajes=personajeRepository.findAll();
        List<PersonajeDTO> personajeDTOS=personajeMapper.personajeEntitySet2DTOList(personajes,false);
        return personajeDTOS;
    }
    public void delete(Long id){
        personajeRepository.deleteById(id);
    }

    public void removePelicula(Long id,Long idPelicula){
        PersonajeEntity entity=personajeRepository.getById(id);
        entity.getPeliculas().size();
        PeliculaEntity peliculaEntity=peliculaService.getEntityById(idPelicula);
        entity.removePelicula(peliculaEntity);
        personajeRepository.save(entity);
    }
    public PersonajeDTO getDetailsById(Long id){
        Optional<PersonajeEntity> entity=personajeRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id personaje no válido");
        }
        PersonajeDTO personajeDTO=personajeMapper.personajeEntity2DTO(entity.get(),true);
        return personajeDTO;
    }
}
