package com.alkemy.movie.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character_film")
@Getter
@Setter
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image_character;

    private String name_character;

    private byte age;

    private String role;

    private String history;

    @ManyToMany(mappedBy = "charactersFilm", cascade = CascadeType.ALL)
    private List<MovieseriesEntity> movieseries = new ArrayList<>();

    // Add and remove character
    public void addMovieseries(MovieseriesEntity movieserie) {this.movieseries.add(movieserie);}

    public void removeMovieseries(MovieseriesEntity movieserie) {this.movieseries.remove(movieserie);}
}
