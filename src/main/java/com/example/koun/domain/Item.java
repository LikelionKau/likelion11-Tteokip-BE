package com.example.koun.domain;

//import static com.example.koun.dto.ItemUpdateRequestDto.convertToDateTime;


//import com.example.koun.dto.ItemUpdateRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "raffle_quantity")
    private int raffleQuantity;

    private String artist;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    private String venue;

    @Column(name = "like_num")
    private int likeNum;

    @Column(name = "item_num")
    private int itemNum;

    @Column(name = "item_name")
    private String itemName;

    private String post;

    @Column(name = "age_requirement")
    private String ageRequirement;

    private String description;

    @Column(name ="running_time")
    private int runningTime;

    @Column(name="upload_time")
    private LocalDateTime uploadTime;

    @OneToMany(mappedBy = "item")
    private List<Raffle> raffles = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<Like> likes = new ArrayList<>();


    @Builder
    public Item(int raffleQuantity, String artist, LocalDateTime dateTime, String venue
            ,int likeNum, int itemNum, String itemName, String post
            , String ageRequirement, String description, int runningTime, LocalDateTime uploadTime) {

        this.raffleQuantity = raffleQuantity;
        this.artist = artist;
        this.dateTime = dateTime;
        this.venue = venue;
        this.likeNum = likeNum;
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.post = post;
        this.ageRequirement = ageRequirement;
        this.description = description;
        this.runningTime = runningTime;
        this.uploadTime = uploadTime;

    }


    //  확장성

//    public void updateItem(ItemUpdateRequestDto itemUpdateRequestDto){
//        this.itemName = itemUpdateRequestDto.getItemName();
//        this.artist = itemUpdateRequestDto.getArtist();
//        this.venue = itemUpdateRequestDto.getVenue();
//        this.dateTime = convertToDateTime(itemUpdateRequestDto.getDateTime());
//        this.ageRequirement = itemUpdateRequestDto.getAgeRequirement();
//        this.runningTime = itemUpdateRequestDto.getRunningTime();
//        this.post = itemUpdateRequestDto.getPost();
//
//    }



}
