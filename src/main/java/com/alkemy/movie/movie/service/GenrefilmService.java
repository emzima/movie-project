package com.alkemy.movie.movie.service;

import com.alkemy.movie.movie.dto.GenrefilmDTO;

import java.util.List;

public interface GenrefilmService {
    GenrefilmDTO save(GenrefilmDTO dto);

    List<GenrefilmDTO> getAllGenrefilms();
}
