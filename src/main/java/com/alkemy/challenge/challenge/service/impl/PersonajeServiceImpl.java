package com.alkemy.challenge.challenge.service.impl;


import com.alkemy.challenge.challenge.controller.PersonajeFiltersDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.entity.Pelicula;
import com.alkemy.challenge.challenge.entity.Personaje;
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

    private PersonajeRepository personajeRepository;
    private PersonajeSpecificacion personajeSpecificacion;

    private PersonajeMapper personajeMapper;

    private PeliculaServiceImpl peliculaService;

    @Autowired
    public PersonajeServiceImpl(
            PersonajeRepository personajeRepository,
            PersonajeSpecificacion personajeSpecificacion,
            PeliculaServiceImpl peliculaService,
            PersonajeMapper personajeMapper
            ){
        this.personajeRepository=personajeRepository;
        this.personajeSpecificacion=personajeSpecificacion;
        this.peliculaService=peliculaService;
        this.personajeMapper=personajeMapper;
    }
    public PersonajeDTO getDetailsById(Long id){
    Optional<Personaje>entity=this.personajeRepository.findById(id);
    if(!entity.isPresent()){
        throw new ParamNotFound("Id personaje no valido");
    }
    PersonajeDTO personajeDTO=this.personajeMapper.personajeEntity2DTO(entity.get(),true);
    return personajeDTO;
    }
    public List<PersonajeDTO>getByFilters(String nombre, String edad, Set<Long> peliculas, String order){
        PersonajeFiltersDTO filtersDTO=new PersonajeFiltersDTO(nombre,edad,peliculas,order);
        List<Personaje>personajes=personajeRepository.findAll(personajeSpecificacion.getByFilters(filtersDTO));
        List<PersonajeDTO>dtos=personajeMapper.personajeEntitySet2DTOList(personajes,true);
        return dtos;
    }
    public PersonajeDTO save(PersonajeDTO dto){
        Personaje personaje =personajeMapper.personajeDTO2Entity(dto);
        Personaje personajeSaved =personajeRepository.save(personaje);
        PersonajeDTO dtos= personajeMapper.personajeEntity2DTO(personajeSaved,false);
        //todo: guardar genero
        System.out.println("GUARDAR PERSONAJE");
        return dtos;
    }


    public List<PersonajeDTO> getAllPersonajes() {
        List<Personaje>personajes=personajeRepository.findAll();
        List<PersonajeDTO> personajeDTOS=personajeMapper.personajeEntitySet2DTOList(personajes,false);
        return personajeDTOS;
    }
    public void delete(Long id){
        personajeRepository.deleteById(id);
    }

    public void removePelicula(Long id,Long idPelicula){
        Personaje entity=personajeRepository.getById(id);
        entity.getPeliculas().size();
        Pelicula pelicula =peliculaService.getEntityById(idPelicula);
        entity.removePelicula(pelicula);
        personajeRepository.save(entity);
    }
}
