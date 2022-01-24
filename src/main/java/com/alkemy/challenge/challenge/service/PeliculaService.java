package com.alkemy.challenge.challenge.service;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.entity.Pelicula;

import java.util.List;

public interface PeliculaService {
    PeliculaDTO save(PeliculaDTO dto);
    List<PeliculaDTO> getAllPeliculas();
    void delete(Long id);
    Pelicula getEntityById(Long id);
}
