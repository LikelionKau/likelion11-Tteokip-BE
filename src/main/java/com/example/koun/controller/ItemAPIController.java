package com.example.koun.controller;

import com.example.koun.dto.ItemLikesDto;
import com.example.koun.dto.ItemNameAndUserIdDto;
import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemAPIController {
    private final ItemService itemService;
    // 새로운 아이템 등록
    @PostMapping("/admin")
    public ResponseEntity<Long> createItem(@RequestBody ItemRequestDto requestDto) {
        Long itemId = itemService.joinItem(requestDto);
        return new ResponseEntity<>(itemId, HttpStatus.CREATED);
    }
    // 특정 아이템 조회
    @GetMapping
    public ResponseEntity<ItemResponseDto> getItem(@RequestParam Long itemId) {
        ItemResponseDto item = itemService.findById(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // 아이템 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteItem(@RequestParam Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // 아이템 이름으로 조회
    @GetMapping("/search")
    public ResponseEntity<?> searchItemsByName(
        @RequestBody ItemNameAndUserIdDto itemNameAndUserIdDto) {
        boolean userLikes = itemNameAndUserIdDto.isUserLikes();

        // 사용자가 아이템을 좋아하지 않는 경우
        if (!userLikes) {
            return ResponseEntity.ok().build();
        }

        // 로그인 되어 있고, 사용자가 아이템을 좋아하는 경우 검색 수행
        ItemResponseDto itemResponseDto = itemService.findItemsByName(
                itemNameAndUserIdDto.getItemName(), itemNameAndUserIdDto.getUserId())

            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 아이템이 없습니다."));

        return ResponseEntity.ok(itemResponseDto);
    }


    // 모든 아이템 조회
    @GetMapping("/all")
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {
        List<ItemResponseDto> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    // 특정 사용자의 좋아요 리스트 조회
    @GetMapping("/users")
    public ResponseEntity<List<ItemResponseDto>> getLikeByUserID(@RequestParam Long userId) {
        List<ItemResponseDto> items = itemService.findAllLikesByUserId(userId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


    // 인기 top 1~10 조회
    @GetMapping("/tops")
    public ResponseEntity<List<ItemLikesDto>> getTopLikedItems(
        @PageableDefault(size = 10) Pageable pageable) {
        List<ItemLikesDto> topLikedItems = itemService.findTopLikedItems(pageable);
        return ResponseEntity.ok(topLikedItems);
    }


}
