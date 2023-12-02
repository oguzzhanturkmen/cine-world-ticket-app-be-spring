package com.cineworld.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "movie_theater")
@Entity
public class MovieTheater {

    private Long id;
    private String thather_name;



}
