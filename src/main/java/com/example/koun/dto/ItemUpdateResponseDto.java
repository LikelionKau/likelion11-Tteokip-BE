package com.example.koun.dto;

import com.example.koun.domain.Item;
import java.time.format.DateTimeFormatter;
import lombok.Data;

@Data
public class ItemUpdateResponseDto {
    private String itemName;
    private String artist;
    private String venue;
    private String dateTime;
    private String ageRequirement;
    private String runningTime;
    private String post;


    public ItemUpdateResponseDto(Item item){
        this.itemName = item.getItemName();
        this.artist = item.getArtist();
        this.venue = item.getVenue();
        this.dateTime = item.getDateTime().format(formatter);
        this.ageRequirement = item.getAgeRequirement();
        this.runningTime = item.getRunningTime();
        this.post = item.getPost();

    }
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


}
