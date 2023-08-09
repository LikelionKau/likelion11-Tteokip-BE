package com.example.koun.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
    name="Raffle",
    uniqueConstraints=
    @UniqueConstraint(columnNames={"user_id", "item_id"})
)
public class Raffle {

    @Id @GeneratedValue
    @Column(name ="raffle_id")
    private Long id;

    @Column(name="raffle_status")
    private String raffleStatus;

    //1인당 최대2매
    @Column(name="raffle_count")
    private int raffleCount;

    @Column(name="raffle_draw_date")
    private LocalDateTime raffleDrawDate;

    @Column(name="application_date")
    private LocalDateTime applicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id" )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="section_id")
    private Section section;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;




    @Builder
    public Raffle(String raffleStatus, int raffleCount, LocalDateTime raffleDrawDate,
        LocalDateTime applicationDate, User user, Item item, Section section, Order order) {
        this.raffleStatus = raffleStatus;
        this.raffleCount = raffleCount;
        this.raffleDrawDate = raffleDrawDate;
        this.applicationDate = applicationDate;
        this.user = user;
        this.item = item;
        this.section = section;
        this.order = order;
    }


    //==연간관계편의메서드==//

    public void setUser(User user) {
        if (this.user != null) {
            this.user.getRaffles().remove(this);
        }
        this.user = user;
        user.getRaffles().add(this);
    }

    public void setItem(Item item) {
        if (this.item != null) {
            this.item.getRaffles().remove(this);
        }
        this.item = item;
        item.getRaffles().add(this);
    }

    public void setSection(Section section) {
        if (this.section != null) {
            this.section.getRaffles().remove(this);
        }
        this.section = section;
        section.getRaffles().add(this);
    }

    public void setOrder(Order order) {
        if (this.order != null) {
            this.order.setRaffle(null);
        }
        this.order = order;
        order.setRaffle(this);
    }


    //생성 메서드





}
