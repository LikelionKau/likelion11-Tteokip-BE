package com.example.koun.dto;


import com.example.koun.domain.Raffle;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RaffleResponseDto {

    private Long id;
    private String raffleStatus;
    private int raffleCount;
    private LocalDateTime raffleDrawDate;
    private LocalDateTime applicationDate;
    private String userEmail;
    private String itemName;
    private String sectionName;


    public RaffleResponseDto(Raffle entity) {
        this.id=entity.getId();
        this.raffleCount= entity.getRaffleCount();
        this.applicationDate=entity.getApplicationDate();
        this.itemName=entity.getItem().getItemName();
        this.userEmail=entity.getUser().getUserEmail();
        this.sectionName=entity.getSection().getSectionName();
        this.raffleStatus=entity.getRaffleStatus();
        this.raffleDrawDate=entity.getRaffleDrawDate();

    }
}