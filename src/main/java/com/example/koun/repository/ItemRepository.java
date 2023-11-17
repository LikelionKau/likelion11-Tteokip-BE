package com.example.koun.repository;

import com.example.koun.domain.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    // 이름으로 아이템 검색
    List<Item> findByNameContainingIgnoreCase(String itemName);

}
