package com.aloysius.Netflixmoviestop100;

import com.aloysius.Netflixmoviestop100.InputData.NetflixData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetflixDataRepository extends JpaRepository<NetflixData, Integer> {

}
