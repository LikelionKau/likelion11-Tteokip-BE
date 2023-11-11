package com.example.koun.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "like_id")
    private Long id;


//    @Column(name = "item_name")
    private String itemName;

    private String raffleState;

    private String venue;

    private String artist;

    private String dateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;


    @Builder
    public Like(User user, Item item, String itemName, String raffleState, String venue, String artist, String dateTime) {
        this.user = user;
        this.item = item;
        this.itemName = itemName;
        this.raffleState = raffleState;
        this.venue = venue;
        this.artist = artist;
        this.dateTime = dateTime;
    }


}
