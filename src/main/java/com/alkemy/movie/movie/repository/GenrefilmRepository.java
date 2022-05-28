package com.alkemy.movie.movie.repository;

import com.alkemy.movie.movie.entity.GenrefilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenrefilmRepository extends JpaRepository<GenrefilmEntity, Long> {
    //System.out.println("entro aca");
}
