package com.example.koun.repository;

import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

}
