package com.example.koun.dto;

import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.koun.domain.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemNameAndUserIdDto {
    private Long userId;
    private String itemName;

    public Item toEntity() {
        return Item.builder()
            .itemName(itemName)
            .build();
    }
}
