package com.alkemy.movie.movie.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movieseries")
@Getter
@Setter
public class movieseriesEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String image;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Byte rating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genrefilm_id", insertable = false, updatable = false)
    private genrefilmEntity genrefilm;

    @Column(name = "genrefilm_id", nullable = false)
    private Long genrefilmId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "character_movieseries",
            joinColumns = @JoinColumn(name= "movieseries_id"),
            inverseJoinColumns = @JoinColumn(name="character_id"))
    private Set<characterEntity> characters = new HashSet<>();
}
