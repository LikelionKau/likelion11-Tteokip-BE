package com.example.koun.dto;


import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeResponseDto{
    private Long userId;
    private Long itemId;
    private Long likeId;



    public LikeResponseDto(Like like){
        this.userId = like.getId();
        this.itemId = like.getId();
        this.likeId = like.getId();


    }



}
