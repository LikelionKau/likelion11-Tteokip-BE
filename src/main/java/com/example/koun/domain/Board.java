package com.example.koun.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@DynamicInsert
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    @Column(name="board_id")
    private Long id;

    private String title;
    private String content;

    @Column(name = "write_time")
    private LocalDateTime writeTime;

    @Column(name="update_time")
    private LocalDateTime updateTime;


    @ColumnDefault("false")
    @Column(name="is_secreted")
    private String isSecreted ;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;


    @Builder
    public Board(String title, String content, LocalDateTime writeTime, LocalDateTime updateTime,
        String isSecreted, User user) {
        this.title = title;
        this.content = content;
        this.writeTime = writeTime;
        this.updateTime = updateTime;
        this.isSecreted = isSecreted;
        this.user = user;
    }

    public void setUser(User user){
         if (this.user != null) {
            this.user.getBoards().remove(this);
        }
         this.user=user;
         user.getBoards().add(this);

    }




}
