package com.example.koun.controller;

import com.example.koun.dto.ItemNameAndUserIdDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.service.ItemService;
import com.example.koun.service.RaffleService;
import java.util.List;
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



//    @PostMapping("/raffle/draw/item")
//    public ResponseEntity<Void> drawRaffleForItem(@RequestBody ItemNameAndUserIdDto requestDto) {
//        Long userId = requestDto.getUserId();
//        String itemName = requestDto.getItemName();
//
//        // findItemsByName 메서드에 ItemNameAndUserIdDto 객체를 전달합니다.
//        List<ItemResponseDto> items = itemService.findItemsByName(requestDto);
//
//        if (items.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 아이템이 없습니다.");
//        }
//
//        // 리스트에서 첫 번째 아이템의 ID를 가져와서 drawRaffleForItem 메서드에 전달
//        raffleService.drawRaffleForItem(items.get(0).getId());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
