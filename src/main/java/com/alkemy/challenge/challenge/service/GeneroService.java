package com.alkemy.challenge.challenge.service;

import com.alkemy.challenge.challenge.dto.GeneroDTO;

import java.util.List;

public interface GeneroService {
     GeneroDTO save(GeneroDTO dto);
     List<GeneroDTO> getAllGeneros();
     void delete(Long id);
}
