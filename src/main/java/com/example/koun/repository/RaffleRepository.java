package com.example.koun.repository;

import com.example.koun.domain.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaffleRepository extends JpaRepository<Raffle, Long> {

    Optional<Raffle> findByUserIdAndItemId(Long userId, Long itemId);
}
