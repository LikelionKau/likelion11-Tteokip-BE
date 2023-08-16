package com.example.koun.controller;


import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.ItemResponseDto;
//import com.example.koun.dto.ItemUpdateRequestDto;
import com.example.koun.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin") // 적절한 URL 경로를 선택해주세요
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

  //   새로윤 아이템 등록
    @PostMapping("/adminWrite")
    public ResponseEntity<Long> createItem(@RequestBody ItemRequestDto requestDto) {
        Long itemId = itemService.joinItem(requestDto);
        return new ResponseEntity<>(itemId, HttpStatus.CREATED);
    }


    // 특정 아이템 조회
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> getItem(@PathVariable Long id) {
        ItemResponseDto item = itemService.findById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // 아이템 정보 업데이트
//    @PutMapping("/{itemId}/update")
//    public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody ItemUpdateRequestDto updateDto) {
//        itemService.updateItem(id, updateDto);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    // 아이템 삭제
    @DeleteMapping("/{itemId}/delete")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 아이템 이름으로 조회
    @GetMapping("/{itemName}")
    public ResponseEntity<ItemResponseDto> searchItemsByName(@PathVariable String itemName) {
        ItemResponseDto item = itemService.findItemsByName(itemName);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // 모든 아이템 조회
    @GetMapping("/all")
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {
        List<ItemResponseDto> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
