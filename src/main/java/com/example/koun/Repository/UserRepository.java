package com.example.koun.Repository;

import com.example.koun.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Item, Long> {


}
