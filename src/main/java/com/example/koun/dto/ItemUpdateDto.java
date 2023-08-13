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
    private String itemName;
    private String post;
    private int ageRequirement;
    private String description;


    @Builder
    public ItemUpdateDto(int raffleQuantity, String artist, LocalDateTime dateTime, String venue, int ticketPrice, int likeNum, String itemName, String description) {
        this.raffleQuantity = raffleQuantity;
        this.artist = artist;
        this.dateTime = dateTime;
        this.venue = venue;
        this.ticketPrice = ticketPrice;
        this.likeNum = likeNum;
        this.itemName = itemName;
        this.description = description;
    }
}
