package com.alkemy.challenge.challenge.controller;

import com.alkemy.challenge.challenge.dto.GeneroDTO;
import com.alkemy.challenge.challenge.service.GeneroService;
import com.alkemy.challenge.challenge.service.impl.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;



    @GetMapping
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generos=generoService.getAllGeneros();
        return ResponseEntity.ok().body(generos);
    }
    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado= generoService.save(genero);
    //guarda genero
        // 201, genero guardado
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        generoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
