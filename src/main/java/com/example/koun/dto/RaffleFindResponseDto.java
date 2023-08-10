package com.example.koun.dto;


import com.example.koun.domain.Raffle;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class RaffleFindResponseDto {

    private Long id;
    private String raffleStatus;
    private int raffleCount;
    private String raffleDrawDate;
    private String applicationDate;
    private String itemName;
    private String sectionName;
    private String dateTime;
    private int price;




    public RaffleFindResponseDto(Raffle entity) {
        this.id=entity.getId();
        this.raffleCount= entity.getRaffleCount();
        this.itemName=entity.getItem().getItemName();
        this.sectionName=entity.getSection().getSectionName();
        this.price = entity.getSection().getPrice();
        this.raffleStatus=entity.getRaffleStatus();
        this.applicationDate = entity.getApplicationDate().format(formatter);
        this.raffleDrawDate = entity.getRaffleDrawDate().format(formatter);
        this.dateTime = entity.getItem().getDateTime().format(formatter);


    }


    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


}