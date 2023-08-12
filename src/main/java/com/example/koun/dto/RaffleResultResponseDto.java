package com.example.koun.dto;

import com.example.koun.domain.Raffle;
import lombok.Builder;
import lombok.Data;

@Data
public class RaffleResultResponseDto {

    private Long id;
    private String itemName;
    private String raffleStatus;
    private String sectionName;
    private int price;
    private int sectionTotalCount;
    private int itemTotalCount;
    private double sectionRate;


    @Builder
    public RaffleResultResponseDto(Long id, String itemName, String raffleStatus, String sectionName,
                                   int price, int sectionTotalCount, int itemTotalCount, double sectionRate) {
        this.id = id;
        this.itemName = itemName;
        this.raffleStatus = raffleStatus;
        this.sectionName = sectionName;
        this.price = price;
        this.sectionTotalCount = sectionTotalCount;
        this.itemTotalCount = itemTotalCount;
        this.sectionRate = sectionRate;
    }


}
