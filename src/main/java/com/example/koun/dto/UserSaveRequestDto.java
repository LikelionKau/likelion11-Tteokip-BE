package com.example.koun.dto;

import com.example.koun.domain.RoleType;
import com.example.koun.domain.User;


import javax.management.relation.Role;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSaveRequestDto {


    private String userName;
    private String userEmail;

    private String password;

    @Builder
    public UserSaveRequestDto(String userName, String userEmail,
                              String password) {
        this.userName = userName;
        this.userEmail = userEmail;

        this.password = password;
    }



    public User toEntity() {
        return User.builder()
                .userName(userName)
                .userEmail(userEmail)
                .password(password)
                .build();

    }

}
