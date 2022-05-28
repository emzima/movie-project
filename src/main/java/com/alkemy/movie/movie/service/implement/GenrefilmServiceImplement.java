package com.alkemy.movie.movie.service.implement;

import com.alkemy.movie.movie.entity.GenrefilmEntity;
import com.alkemy.movie.movie.mapper.GenrefilmMapper;
import com.alkemy.movie.movie.repository.GenrefilmRepository;
import com.alkemy.movie.movie.service.GenrefilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.movie.movie.dto.GenrefilmDTO;

import java.util.List;

@Service
public class GenrefilmServiceImplement implements GenrefilmService {

    @Autowired
    private GenrefilmMapper genrefilmMapper;
    @Autowired
    private GenrefilmRepository genrefilmRepository;

    public GenrefilmDTO save(GenrefilmDTO dto) {
        //System.out.println("entro aca");
        GenrefilmEntity entity = genrefilmMapper.genrefilmDTO2Entity(dto);
        GenrefilmEntity entitySaved = genrefilmRepository.save(entity);
        GenrefilmDTO result = genrefilmMapper.genrefilmEntity2DTO(entitySaved); //guardar genero
        return result;
    }
    public List<GenrefilmDTO> getAllGenrefilms() {
        List<GenrefilmEntity> entities = genrefilmRepository.findAll();
        List<GenrefilmDTO> result = genrefilmMapper.genrefilmEntityLlist2DTOList(entities);
        return result;
    }
}
