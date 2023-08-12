package com.example.koun.repository;


import com.example.koun.domain.Section;
import com.example.koun.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository <Section, Long> {

}
