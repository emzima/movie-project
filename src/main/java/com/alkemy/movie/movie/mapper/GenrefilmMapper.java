package com.alkemy.movie.movie.mapper;

import com.alkemy.movie.movie.dto.GenrefilmDTO;
import com.alkemy.movie.movie.entity.GenrefilmEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenrefilmMapper {

    public GenrefilmEntity genrefilmDTO2Entity(GenrefilmDTO dto) {
        GenrefilmEntity genrefilmEntity = new GenrefilmEntity();
        genrefilmEntity.setName_genre(dto.getName_genre());
        genrefilmEntity.setImage_genre(dto.getImage_genre());
        return genrefilmEntity;
    }

    public GenrefilmDTO genrefilmEntity2DTO(GenrefilmEntity entity) {
        GenrefilmDTO dto = new GenrefilmDTO();
        dto.setId(entity.getId());
        dto.setName_genre(entity.getName_genre());
        dto.setImage_genre(entity.getImage_genre());
        return dto;
    }

    public List<GenrefilmDTO> genrefilmEntityLlist2DTOList(List<GenrefilmEntity> entities) {
        List<GenrefilmDTO> dtos = new ArrayList<>();
        for (GenrefilmEntity entity : entities){
            dtos.add(this.genrefilmEntity2DTO(entity));
        }
        return dtos;
    }
}
