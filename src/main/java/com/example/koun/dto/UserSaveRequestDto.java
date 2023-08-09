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
    private RoleType roleType;
    private boolean isDeleted;
    private String oauth;
    private String password;

    @Builder
    public UserSaveRequestDto(String userName, String userEmail, RoleType roleType,
        boolean isDeleted, String oauth, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.roleType = roleType;
        this.isDeleted = isDeleted;
        this.oauth=oauth;
        this.password = password;
    }


    public User toEntity(){
        return User.builder()
            .userName(userName)
            .userEmail(userEmail)
            .roleType(roleType)
            .isDeleted(isDeleted)
            .oauth(oauth)
            .password(password)
            .build();
    }

}
