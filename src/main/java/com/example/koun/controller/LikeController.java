package com.example.koun.controller;

import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.LikeRequestDto;
import com.example.koun.service.ItemService;
import com.example.koun.service.LikeService;
import com.example.koun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    private final ItemService itemService;
    private final LikeService likeService;


    @GetMapping("/item")
    public String Item(ItemRequestDto itemRequestDto){
        System.out.println("아이템 좋아요:" + itemRequestDto.getItemName());
        return "item";

    }

    @PostMapping("/item/register/like")
    public String saveLike(LikeRequestDto likeRequestDto){
        System.out.println("테스트 dto 이름" + likeRequestDto.getItemName());
        likeService.joinLike(likeRequestDto);
        return "main";

    }


}
