package com.example.koun.login.auth.kakao;



import lombok.Data;



@Data
public class KakaoProfile {

    private long id;
    private String connected_at;
    private Properties properties;
    private KakaoAccount kakao_account;
    private String access_token;
    private String token_type; // 추가된 필드
    private String refresh_token; // 추가된 필드
    private int expires_in; // 추가된 필드
    private String scope; // 추가된 필드

}


