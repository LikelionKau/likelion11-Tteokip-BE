package com.example.koun.dto;

import com.example.koun.domain.Item;
import java.time.LocalDateTime;
import lombok.Data;

// 엔티티에서 값을 불러받을 때 사용되는 DTO
@Data
public class ItemResponseDto {
    private int raffleQuantity;
    private String artist;
    private LocalDateTime dateTime;
    private String venue;
    private int ticketPrice;
    private int likeNum;
    private String itemName;
    private String description;

    //파라미터로 Entity를 받으면 Dto로
    public ItemResponseDto(Item item){
            this.raffleQuantity = item.getRaffleQuantity();
            this.artist = item.getArtist();
            this.dateTime = item.getDateTime();
            this.venue = item.getVenue();
            this.likeNum = item.getLikeNum();
            this.itemName = item.getItemName();
            this.description = item.getDescription();
        }

    }



