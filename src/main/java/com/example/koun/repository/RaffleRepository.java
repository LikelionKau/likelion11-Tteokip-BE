package com.example.koun.repository;

import com.example.koun.domain.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository<Raffle,Long> {

}
