package com.alkemy.movie.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
@Getter
@Setter
public class characterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String image;

    private String Name;

    private byte age;

    @Column(name = "weight_film")
    private Integer weightFilm;

    private String History;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<movieseriesEntity> movieseries = new ArrayList<>();
}
