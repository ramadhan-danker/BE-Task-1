package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private float rating;
    private String year;
    private String month;
    private String certificate;
    private String runtime;
    private String director;
    private String stars;
    private String genre;
    private String filming_location;
    private double budget;
    private double income;
    private String country_of_origin;

}
