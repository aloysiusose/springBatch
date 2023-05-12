package com.aloysius.Netflixmoviestop100.InputData;

import org.springframework.batch.item.ItemProcessor;

public class DataProcessor implements ItemProcessor<NetflixInput, NetflixData> {

    @Override
    public NetflixData process(NetflixInput netflixInput) throws Exception {

        NetflixData netflixData = new NetflixData();
        netflixData.setRank(Integer.parseInt(netflixInput.getRank()));
        netflixData.setMovieTitle(netflixInput.getMovie_Title());
        netflixData.setYearOfRelease(Integer.parseInt(netflixInput.getYear()));
        netflixData.setRating(Double.parseDouble(netflixInput.getScore()));
        netflixData.setDirector(netflixInput.getDirector());
        netflixData.setCast(netflixInput.getCast());
        netflixData.setCriticsConsensus(netflixInput.getCritics_Consensus());



        return netflixData;
    }
}
