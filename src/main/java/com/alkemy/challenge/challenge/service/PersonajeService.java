package com.alkemy.challenge.challenge.service;


import com.alkemy.challenge.challenge.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

public interface PersonajeService {
    PersonajeDTO save(PersonajeDTO dto);
    List<PersonajeDTO> getAllPersonajes();
    void delete(Long id);
    void removePelicula(Long id,Long idPelicula);
    List<PersonajeDTO>getByFilters(String nombre, String edad, Set<Long> peliculas, String order);

}
