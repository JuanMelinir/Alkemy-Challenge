package com.alkemy.challenge.challenge.controller;


import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.dto.PersonajeDTO;
import com.alkemy.challenge.challenge.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getDetailsByFilters(
            @RequestParam(required = false)String nombre,
            @RequestParam(required = false)String edad,
            @RequestParam(required = false) Set<Long> peliculas,
            @RequestParam(required = false,defaultValue = "ASC")String order
            ){
        List<PersonajeDTO> personajes=personajeService.getByFilters(nombre,edad,peliculas,order);
        return ResponseEntity.ok().body(personajes);
    }
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        List<PersonajeDTO> personajes=personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes);
    }
    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje){
        PersonajeDTO personajeGuardado=personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/{id}/pelicula/{idPais}")
    public ResponseEntity <Void> removePais(@PathVariable Long id,@PathVariable Long idPelicula){
        personajeService.removePelicula(id,idPelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}