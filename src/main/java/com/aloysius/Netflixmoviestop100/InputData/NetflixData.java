package com.aloysius.Netflixmoviestop100.InputData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NetflixData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rank;
    private String movieTitle;
    private int yearOfRelease;
    private double Rating;
    private String director;
    private String cast;
    private String criticsConsensus;
}
