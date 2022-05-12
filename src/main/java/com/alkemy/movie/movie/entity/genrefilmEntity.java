package com.alkemy.movie.movie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genrefilm")
@Getter
@Setter
public class genrefilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String Name;

    private String image;

}
