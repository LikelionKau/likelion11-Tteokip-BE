package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Section;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SectionSaveRequestDto {

    // userId 추가
    private Long userId;

    private int price;

    private int seatQuantity;

    private String itemName;

    private String sectionName;



    @Builder
    public SectionSaveRequestDto(Long userId, int price, int seatQuantity, String itemName, String sectionName) {
        this.userId = userId;
        this.price = price;
        this.seatQuantity = seatQuantity;
        this.itemName = itemName;
        this.sectionName = sectionName;
    }


    public Section toEntity(Item item) {
        return Section.builder()
                .price(price)
                .seatQuantity(seatQuantity)
                .sectionName(sectionName)
                .item(item)
                .build();

    }


}
