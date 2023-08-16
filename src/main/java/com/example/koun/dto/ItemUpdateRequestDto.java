//package com.example.koun.dto;
//
//import com.example.koun.domain.Item;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//public class ItemUpdateRequestDto {
//    private String itemName;
//    private String artist;
//    private String venue;
//    private String dateTime;
//    private String ageRequirement;
//    private int runningTime;
//    private String post;
//
//
//
//    @Builder
//    public ItemUpdateRequestDto(String itemName, String artist, String venue, String dateTime, String ageRequirement, int runningTime, String post) {
//        this.itemName = itemName;
//        this.artist = artist;
//        this.venue = venue;
//        this.dateTime = dateTime;
//        this.ageRequirement = ageRequirement;
//        this.runningTime = runningTime;
//        this.post = post;
//    }
//
//    public Item toEntitiy(){
//        return Item.builder()
//            .itemName(itemName)
//            .artist(artist)
//            .venue(venue)
//            .dateTime(convertToDateTime(dateTime))
//            .ageRequirement(ageRequirement)
//            .runningTime(runningTime)
//            .post(post)
//            .build();
//
//
//    }
//    // 문자열을 LocalDateTime으로 변환하는 메서드
//    public static LocalDateTime convertToDateTime(String dateString) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        return LocalDateTime.parse(dateString, formatter);
//    }
//}
