package com.example.koun.repository;

import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface LikeRepository extends JpaRepository<Like, Long> {
    // 이름으로 아이템 검색
    Optional<Like> findByItemName(String itemName);

}
