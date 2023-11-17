package com.example.koun.login.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.koun.dto.UserSaveResponseDto;
import com.example.koun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class JwUtil {

    @Autowired
    private UserRepository userRepository;
    private static final String SECRET = "koun1234";

    public static String createToken(UserSaveResponseDto userDto){


        // 사용자의 ID와 이메일을 토큰의 페이로드로 사용
        String token = JWT.create()
                .withClaim("userId", userDto.getId())
                .withClaim("email", userDto.getUserEmail())
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public static  boolean verifyToken(String token){
        try {
            JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            // 토큰이 유효하지 않거나 만료된 경우
            return false;
        }
    }

}
