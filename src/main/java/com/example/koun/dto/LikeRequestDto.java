package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeRequestDto {

    private String itemName;
    private String artist;
    private String dateTime;
    private String venue;
    private String raffleState;
    private String enter;


    @Builder
    public LikeRequestDto(String itemName, String artist, String dateTime, String venue,
        String raffleState) {
        this.itemName = itemName;
        this.artist = artist;
        this.dateTime = dateTime;
        this.venue = venue;
        this.raffleState = raffleState;

    }

    public Like toEntity() {
        return Like.builder()
            .itemName(itemName)
            .artist(artist)
            .dateTime(dateTime)
            .venue(venue)
            .raffleState(raffleState)
//            .user(user)
//            .item(item)
            .build();
    }
}
