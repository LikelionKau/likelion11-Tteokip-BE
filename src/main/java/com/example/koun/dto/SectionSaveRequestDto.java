package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Section;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
public class SectionSaveRequestDto {

    private int price;


    private int seatQuantity;

    private Long itemId;

    private String sectionName;

    @Builder
    public SectionSaveRequestDto(int price, int seatQuantity, Long itemId, String sectionName) {
        this.price = price;
        this.seatQuantity = seatQuantity;
        this.itemId = itemId;
        this.sectionName = sectionName;
    }


    public Section toEntity(Item item){
        return Section.builder()
            .price(price)
            .seatQuantity(seatQuantity)
            .sectionName(sectionName)
            .item(item)
            .build();

    }





}
