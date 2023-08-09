package com.example.koun.dto;

import com.example.koun.domain.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class RaffleRequestDto {
    private String raffleStatus;
    private int raffleCount;
    private LocalDateTime raffleDrawDate;
    private LocalDateTime applicationDate;
    private Long userId;
    private Long itemId;
    private Long sectionId;

    @Builder
    public RaffleRequestDto(String raffleStatus, int raffleCount, String raffleDrawDate,
                            Long userId, Long itemId, Long sectionId) {
        this.raffleStatus = raffleStatus;
        this.raffleCount = raffleCount;
        this.raffleDrawDate = convertToDateTime(raffleDrawDate);
        this.userId = userId;
        this.itemId = itemId;
        this.sectionId = sectionId;
    }

    public Raffle toEntity(User user, Item item, Section section) {
        return Raffle.builder()
                .raffleStatus(raffleStatus)
                .raffleCount(raffleCount)
                .raffleDrawDate(raffleDrawDate)
                .user(user)
                .item(item)
                .section(section)
                .build();
    }

    // 문자열을 LocalDateTime으로 변환하는 메서드
    private LocalDateTime convertToDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateString, formatter);
    }
}