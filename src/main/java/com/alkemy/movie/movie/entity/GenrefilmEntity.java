package com.alkemy.movie.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genrefilm")
@Getter
@Setter
public class GenrefilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name_genre;

    private String image_genre;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<MovieseriesEntity> movieseries = new ArrayList<>();

}
