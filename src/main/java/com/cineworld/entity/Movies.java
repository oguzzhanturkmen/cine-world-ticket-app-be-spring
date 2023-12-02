package com.cineworld.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movies {

    private Long id;
    private Integer movie_id;
    private String title;
    private String overview;
    private String poster_path;
    private String backdrop_path;
    private String release_date;
    private String vote_average;
    private String vote_count;
    private String popularity;
    private String original_language;
    private String original_title;
    private String adult;
    private String video;
    private String genre_ids;
    private String state;


}
