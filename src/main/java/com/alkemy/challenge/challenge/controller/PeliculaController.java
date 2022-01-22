package com.alkemy.challenge.challenge.controller;


import com.alkemy.challenge.challenge.dto.PeliculaDTO;
import com.alkemy.challenge.challenge.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getAll(){
        List<PeliculaDTO> peliculas=peliculaService.getAllPeliculas();
        return ResponseEntity.ok().body(peliculas);
    }
    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula){
        PeliculaDTO peliculaGuardada=peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }
}
