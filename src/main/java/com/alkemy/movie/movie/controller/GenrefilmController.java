package com.alkemy.movie.movie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.alkemy.movie.movie.dto.GenrefilmDTO;
import com.alkemy.movie.movie.service.GenrefilmService;

import java.util.List;

@RestController
@RequestMapping("genrefilms")
public class GenrefilmController {
    private GenrefilmService genrefilmService;

    @Autowired
    public GenrefilmController(GenrefilmService genrefilmService) {
        this.genrefilmService = genrefilmService;
    }

    @GetMapping
    public ResponseEntity<List<GenrefilmDTO>> getAll() {
        List<GenrefilmDTO> genrefilms = this.genrefilmService.getAllGenrefilms();
        return ResponseEntity.ok().body(genrefilms);
    }

    @PostMapping
    public ResponseEntity<GenrefilmDTO> save(@RequestBody GenrefilmDTO genrefilm ) {
        //System.out.println("entro aca");
        GenrefilmDTO genrefilmSave = this.genrefilmService.save(genrefilm) ; //save
        return  ResponseEntity.status(HttpStatus.CREATED).body(genrefilmSave);   // 201 devuelve el guardado
    }
}
