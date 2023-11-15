package com.example.koun.service;

import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import com.example.koun.dto.ItemLikesDto;
import com.example.koun.dto.ItemNameAndUserIdDto;
import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.dto.LikeResponseDto;
import com.example.koun.dto.RaffleFindResponseDto;
import com.example.koun.repository.ItemRepository;
import com.example.koun.repository.UserRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    // 새로운 아이템 등록
    @Transactional
    public Long joinItem(ItemRequestDto itemRequestDto) {
        Item item = itemRequestDto.toEntity(); // ItemDto를 Item 엔티티로 변환
        return itemRepository.save(item).getId();
    }

    // 특정 아이템 조회
    @Transactional(readOnly = true)
    public ItemResponseDto findById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + itemId));
        return new ItemResponseDto(item); // Item 엔티티를 ItemDto로 변환하여 반환
    }



    @Transactional
    // 아이템 삭제
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + itemId));
        itemRepository.delete(item);
    }


    @Transactional
    // 아이템 이름으로 조회
    public Optional<ItemResponseDto> findItemsByName(String itemName, Long userId) {
        // ItemRepository의 쿼리 메소드를 호출하여 Item 객체를 Optional로 받음
        Optional<Item> item = itemRepository.findByItemNameAndUserId(itemName, userId);
        // Item 객체가 존재하면 DTO로 변환하여 반환
        return item.map(ItemResponseDto::new);
    }




    // 모든 아이템 조회
    @Transactional(readOnly = true)
    public List<ItemResponseDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
            .map(ItemResponseDto::new)
            .collect(Collectors.toList());
    }


    // 특정 사용자 좋아요 리스트 조회
    @Transactional(readOnly = true)
    public List<ItemResponseDto> findAllLikesByUserId(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("사용자 ID [" + userId + "]에 해당하는 사용자를 찾을 수 없습니다."));

        List<Like> likes = user.getLikes(); // User 엔티티에서 Like 리스트를 가져옴

        // Like 엔티티를 ItemResponseDto로 변환
        List<ItemResponseDto> itemResponseDtos = likes.stream()
            .map(like -> new ItemResponseDto(like.getItem())) // 가정: Like 엔티티에 getItem() 메서드가 있다고 가정합니다.
            .collect(Collectors.toList());

        return itemResponseDtos;
    }


    @Transactional
    // 인기 top 1~10 조회
    public List<ItemLikesDto> findTopLikedItems(Pageable pageable) {
        Pageable topTen = PageRequest.of(0, 10);
        List<Object[]> results = itemRepository.findTopLikedItems(topTen);

        return results.stream()
            .map(result -> new ItemLikesDto((Item) result[0], (Long) result[1]))
            .collect(Collectors.toList());
    }




//    public List<ItemLikesDto> findTopLikedItems(int topN) {
//        List<Like> likes = likeRepository.findAll(); // 모든 '좋아요'를 가져옵니다.
//
//        Map<Item, Long> likesCount = likes.stream()
//            .collect(Collectors.groupingBy(Like::getItem, Collectors.counting())); // 아이템별로 '좋아요'의 수를 계산합니다.
//
//        return likesCount.entrySet().stream()
//            .sorted(Map.Entry.<Item, Long>comparingByValue().reversed()) // '좋아요'의 수가 많은 순으로 정렬합니다.
//            .limit(topN) // 상위 N개만 가져옵니다.
//            .map(entry -> new ItemLikesDto(entry.getKey().getId(), entry.getKey().getName(), entry.getValue())) // DTO로 변환합니다.
//            .collect(Collectors.toList()); // 결과 리스트를 반환합니다.
//    }


}