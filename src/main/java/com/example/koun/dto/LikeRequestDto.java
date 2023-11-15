package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeRequestDto {
    private Long userId;
    private Long itemId;


    public Like toEntity(User user ,Item item) {
        return Like.builder()
            .user(user)
            .item(item)
            .build();

    }


}
