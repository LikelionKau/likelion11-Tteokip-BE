package com.example.koun.dto;

import com.example.koun.domain.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemLikesDto {
    private Item item;
    private Long likesNum;

    public ItemLikesDto(Item item, Long likesNum) {
        this.item = item;
        this.likesNum = likesNum;
    }

    // getters and setters
}
