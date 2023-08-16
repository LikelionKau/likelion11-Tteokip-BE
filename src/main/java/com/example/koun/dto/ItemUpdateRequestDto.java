package com.example.koun.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class ItemUpdateDto {
    private int raffleQuantity;
    private String artist;
    private LocalDateTime dateTime;
    private String venue;
    private int ticketPrice;
    private int likeNum;
    private int itemNum;
    private String itemName;
    private String post;
    private String ageRequirement;
    private String description;
    private int viewingTime;


    @Builder
    public ItemUpdateDto(int raffleQuantity, String artist, LocalDateTime dateTime, String venue, int ticketPrice, int likeNum, String itemName,int itemNum, String ageRequirement , String description, int viewingTime) {
        this.raffleQuantity = raffleQuantity;
        this.artist = artist;
        this.dateTime = dateTime;
        this.venue = venue;
        this.ticketPrice = ticketPrice;
        this.likeNum = likeNum;
        this.itemName = itemName;
        this.itemNum = itemNum;
        this.ageRequirement= ageRequirement;
        this.description = description;
        this.viewingTime = viewingTime;
    }
}
