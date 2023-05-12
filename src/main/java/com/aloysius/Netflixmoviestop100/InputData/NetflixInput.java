package com.aloysius.Netflixmoviestop100.InputData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NetflixInput {
    private String Rank;
    private String Movie_Title;
    private String Year;
    private String Score;
    private String Director;
    private String Cast;
    private String Critics_Consensus;
}
