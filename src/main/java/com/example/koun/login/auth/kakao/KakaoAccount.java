package com.example.koun.login.auth.kakao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoAccount {

    private boolean profile_nickname_needs_agreement;
    private Profile profile;
    private boolean has_email;
    private boolean email_needs_agreement;
    private boolean is_email_valid;
    private boolean is_email_verified;
    private String email;
    private boolean has_age_range;
    private boolean age_range_needs_agreement;
    private boolean has_birthday;
    private boolean birthday_needs_agreement;
    private boolean has_gender;
    private boolean gender_needs_agreement;




}
