package com.example.koun.controller;

import com.example.koun.dto.ItemNameAndUserIdDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.service.ItemService;
import com.example.koun.service.RaffleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final RaffleService raffleService;
    private final ItemService itemService;



    @PostMapping("/raffle/draw/item")
    public ResponseEntity<Void> drawRaffleForItem(@RequestBody ItemNameAndUserIdDto requestDto) {
        // TODO: JWT 토큰 검증 및 관리자 권한 확인 로직

        // 아이템 이름으로 조회하는 로직 필요
        Long userId = requestDto.getUserId();
        String itemName = requestDto.getItemName();

        // findItemsByName이 Optional을 반환하므로, 값이 존재하지 않을 경우 예외를 던지도록 처리
        ItemResponseDto itemResponseDto = itemService.findItemsByName(itemName, userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 아이템이 없습니다."));

        // ItemResponseDto 객체에서 ID를 가져와서 drawRaffleForItem 메서드에 전달
        raffleService.drawRaffleForItem(itemResponseDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
