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
public interface ItemRepository extends JpaRepository<Item, Long> {

    // 이름으로 아이템 검색
    Optional<Item> findByItemNameAndUserId(String itemName, Long userId);

    // 좋아요 인기순 (top 1~10)
    @Query("SELECT l.item, COUNT(l) as likesCount FROM Like l GROUP BY l.item ORDER BY likesCount DESC")
    List<Object[]> findTopLikedItems(Pageable pageable);



}