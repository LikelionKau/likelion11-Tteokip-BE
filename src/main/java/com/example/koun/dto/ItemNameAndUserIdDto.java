package com.example.koun.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemNameAndUserIdDto {
    private Long userId;
    private String itemName;
    private boolean userLikes;

    public boolean isUserLikes() {
        return userLikes;
    }

    public void setUserLikes(boolean userLikes){
        this.userLikes = userLikes;
    }
}
