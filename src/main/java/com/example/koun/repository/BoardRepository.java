package com.example.koun.repository;

import com.example.koun.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardWriteRepository extends JpaRepository<Board,Long> {

}
