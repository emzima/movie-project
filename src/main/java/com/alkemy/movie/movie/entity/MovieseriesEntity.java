package com.alkemy.movie.movie.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movieseries")
@Getter
@Setter
public class MovieseriesEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String image_movieseries;

    private String title;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate createdDate;

    private Byte rating;

    @Column(name = "type_movie_serie")
    private String typeMovieOrSerie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genrefilm_id", insertable = false, updatable = false)
    private GenrefilmEntity genrefilm;

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
    private Set<CharacterEntity> charactersFilm = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieseriesEntity other = (MovieseriesEntity) obj;
        return other.id == this.id;
    }
}
