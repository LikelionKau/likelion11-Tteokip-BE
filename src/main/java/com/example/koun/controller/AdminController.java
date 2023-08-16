package com.example.koun.controller;

import com.example.koun.domain.Item;
import com.example.koun.repository.ItemRepository;
import com.example.koun.service.RaffleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final RaffleService raffleService;
    private final ItemRepository itemRepository;


    @PostMapping("/raffle/draw/item/{itemName}")
    public ResponseEntity<Void> drawRaffleForItem(@PathVariable String itemName) {
        // TODO: JWT 토큰 검증 및 관리자 권한 확인 로직


        //아이템 이름으로 조회하는 로직 필요
        Item item = itemRepository.findByItemName(itemName)
                .orElseThrow(()-> new IllegalArgumentException("해당 item이 없습니다"));
        raffleService.drawRaffleForItem(item.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
