package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Order;
import com.example.koun.domain.Section;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class SectionFindResponseDto {
    private Long id;
    private int price;
    private int seatQuantity;
    private String itemName;


    /*사용자에게 보여지는 구역의 정보*/
    public SectionFindResponseDto(Section entity) {
        this.id = entity.getId();
        this.price = entity.getPrice();
        this.seatQuantity = entity.getSeatQuantity();
        this.itemName = entity.getItem().getItemName();
    }

}
