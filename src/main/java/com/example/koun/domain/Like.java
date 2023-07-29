package com.example.koun.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="likes")
public class Like {

    @Id @GeneratedValue
    @Column(name="like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;


    @Builder
    public Like(User user, Item item) {
        this.user = user;
        this.item = item;
    }

    public void setUser(User user) {
        if (this.user != null) {
            this.user.getLikes().remove(this);
        }
        this.user = user;
        user.getLikes().add(this);
    }

    public void setItem(Item item) {
        if (this.item != null) {
            this.item.getLikes().remove(this);
        }
        this.item = item;
        item.getLikes().add(this);
    }


}
