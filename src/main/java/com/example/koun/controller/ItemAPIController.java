package com.example.koun.controller;

//import com.example.koun.dto.ItemLikesDto;

import com.example.koun.dto.ItemNameAndUserIdDto;
import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemAPIController {

    //    @Autowired
    private final ItemService itemService;

    // 새로운 아이템 등록 -- 통과
    @PostMapping("/admin")
    public ResponseEntity<Long> createItem(@RequestBody ItemRequestDto requestDto) {
        Long itemId = itemService.joinItem(requestDto);
        return new ResponseEntity<>(itemId, HttpStatus.CREATED);
    }

    // 특정 아이템 조회 -- 통과
    @GetMapping("{itemid}")
    public ResponseEntity<ItemResponseDto> getItem(@RequestParam Long itemId) {
        ItemResponseDto item = itemService.findById(itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }


    // 모든 아이템 조회 -- 성공
    @GetMapping("/all")
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {
        List<ItemResponseDto> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }



//
//    // 아이템 삭제
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> deleteItem(@RequestParam String itemName) {
//        itemService.deleteItemByName(itemName);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


//    // TODO: 아이템 이름으로 검색
//    @GetMapping("/search")
//    public ResponseEntity<List<ItemResponseDto>> searchItemsByName(
//        @RequestBody ItemNameAndUserIdDto itemNameAndUserIdDto) {
//        Long userId = itemNameAndUserIdDto.getUserId();
//        String itemName = itemNameAndUserIdDto.getItemName();
//
//        // 사용자의 좋아요 여부 판단
//        boolean userLikes = itemService.checkUserLikes(userId, itemName);
//
//        if (!userLikes) {
//            return ResponseEntity.ok().build();
//        }
//
//        // 로그인되어 있고, 사용자가 아이템을 좋아하는 경우 검색 수행
//        List<ItemResponseDto> items = itemService.findItemsByName(itemNameAndUserIdDto);
//
//        return new ResponseEntity<>(items, HttpStatus.OK);
//    }
//
//
//
//
//
//    // 특정 유저가 좋아요한 아이템
//    @GetMapping("/users")
//    public ResponseEntity<List<ItemResponseDto>> getLikeByUserID(@RequestParam Long userId) {
//        List<ItemResponseDto> items = itemService.findAllLikesByUserId(userId);
//        return new ResponseEntity<>(items, HttpStatus.OK);
//    }

    // 인기 top 1~10 조회 (likeNum 기준) -- 통과

    @GetMapping("/tops")
    public ResponseEntity<Page<ItemResponseDto>> list(
        @PageableDefault(size = 10, sort = "likeNum", direction = Sort.Direction.DESC)
        Pageable pageable) {
        Page<ItemResponseDto> topLikedItems = itemService.getTopLikes(pageable);
        return new ResponseEntity<>(topLikedItems, HttpStatus.OK);
    }



    // 신규 top 1 ~ 10 조회 (uploadTime 기준) -- 통과
    @GetMapping("/uploads")
    public ResponseEntity<Page<ItemResponseDto>> listNewTops(
        @PageableDefault(size = 10, sort = "uploadTime", direction = Sort.Direction.DESC)
        Pageable pageable) {
        Page<ItemResponseDto> newTopItems = itemService.getNewTopLikes(pageable);
        return new ResponseEntity<>(newTopItems, HttpStatus.OK);
    }
}



