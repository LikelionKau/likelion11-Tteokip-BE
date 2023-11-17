package com.example.koun.dto;

import com.example.koun.domain.Item;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemRequestDto { //requestDto 생성

    private int raffleQuantity;
    private String artist;
    private LocalDateTime dateTime;
    private String venue;
    private int ticketPrice;
    private int likeNum;
    private String itemName;
    private String description;

    // 1. 프론트에서 itemRequestDto에 대한 파라미터 정보를 받는다.
    // 2. 빌더 패턴으로 requestDto 생성
    @Builder
    public ItemRequestDto(int raffleQuantity, String artist, LocalDateTime dateTime, String venue, int ticketPrice, int likeNum, String itemName, String description) {
            this.raffleQuantity = raffleQuantity;
            this.artist = artist;
            this.dateTime = dateTime;
            this.venue = venue;
            this.ticketPrice = ticketPrice;
            this.likeNum = likeNum;
            this.itemName = itemName;
            this.description = description;
    }



    // DB에 저장될 때는 toEntity 함수를 사용해서 저장 , 반환할 때는 id 번호 줌
    public Item toEntity() {
        return Item.builder()
            .raffleQuantity(raffleQuantity)
            .artist(artist)
            .dateTime(dateTime)
            .venue(venue)
            .likeNum(likeNum)
            .itemName(itemName)
            .description(description)
            .build();
    }
}



