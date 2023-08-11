package com.example.koun.repository;


import com.example.koun.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository <Section, Long> {
}
