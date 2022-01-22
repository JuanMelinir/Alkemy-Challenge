package com.alkemy.challenge.challenge.service;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;

import java.util.List;

public interface PeliculaService {
    PeliculaDTO save(PeliculaDTO dto);
    List<PeliculaDTO> getAllPeliculas();
    void delete(Long id);
}
