package com.example.koun.controller;

import com.example.koun.dto.LikeRequestDto;
import com.example.koun.service.ItemService;
import com.example.koun.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeAPIController {

    private final LikeService likeService;
    private final ItemService itemService;

    // 새로운 좋아요 등록
    @PostMapping("/create")
    public ResponseEntity<Long> createLike(@RequestBody LikeRequestDto likeRequestDto) {
        Long likeId = likeService.joinLike(likeRequestDto);
        return new ResponseEntity<>(likeId, HttpStatus.CREATED);
    }


    // 좋아요 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteLike(@RequestParam Long likeId) {
        likeService.deleteLike(likeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}

