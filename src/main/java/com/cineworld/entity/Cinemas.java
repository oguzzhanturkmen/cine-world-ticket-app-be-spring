package com.cineworld.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cinemas")
public class Cinemas {

    private Long id;
    private String name;
    private String address;
    private String telephone;
    private String url;
    private String city;
    private String state;



}
