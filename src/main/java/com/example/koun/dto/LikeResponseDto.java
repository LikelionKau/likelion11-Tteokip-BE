package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import lombok.Data;

@Data
public class LikeResponseDto{
    private Long id;
    private Item item;
    private String itemName;
    private String artist;
    private String dateTime;
    private String venue;
    private String raffleState;
    private User user;


    public LikeResponseDto(Like like){
        this.id = like.getId();
        this.item = like.getItem();
        this.itemName = like.getItemName();
        this.artist = like.getArtist();
        this.dateTime = like.getDateTime();
        this.venue = like.getVenue();
        this.raffleState = like.getRaffleState();
        this.user = like.getUser();
    }



}
