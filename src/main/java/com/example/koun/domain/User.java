package com.example.koun.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
@Table(name="users")
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;



    @Column(name="user_name",nullable=false)
    private String userName;

    @Column(nullable=false)
    private String password;

    @Column(name="user_email",nullable=false)
    private String userEmail;

    @Column(name="phone_num",nullable=false)
    private String phoneNum;

    @Column(name="user_birth",nullable=false)
    private LocalDateTime userBirth;


    private String account;

    @Column(nullable=false)
    private char gender;

    @Column(name="user_address",nullable=false)
    private String userAddress;


    @Column(name="is_deleted")
    @ColumnDefault("false")
    private Boolean isDeleted=false;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("USER")
    private RoleType roleType=RoleType.USER;

/*----------------------------------여기까지 필드-------------------------------------------*/

    @OneToMany(mappedBy = "user")
    private List<Raffle> raffles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

/*--------------------------여기까지 @OneToMany 어노테이션은 JPA에서 일대다 관계를 표현할 때 사용되는 어노테이션입니다.------------------------------------*/
    @Builder
    public User(String userName, String password, String userEmail, String phoneNum
                , LocalDateTime userBirth, String account, char gender, String userAddress
                , Boolean isDeleted, RoleType roleType, List<Raffle> raffles, List<Order> orders
                 , List<Board> boards, List<Like> likes) {

        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
        this.phoneNum = phoneNum;
        this.userBirth = userBirth;
        this.account = account;
        this.gender = gender;
        this.userAddress = userAddress;
        this.isDeleted = isDeleted;
        this.roleType = roleType;
        this.raffles = raffles;
        this.orders = orders;
        this.boards = boards;
        this.likes = likes;
    }

    public static void main(String[] args) {
        User user = User.builder().userName("adf").gender('W').build();
    }

}
