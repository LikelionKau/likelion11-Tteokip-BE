package com.example.koun.Repository;

import com.example.koun.domain.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository <Raffle, Long> {

}
