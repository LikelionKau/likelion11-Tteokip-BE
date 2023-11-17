package com.example.koun.service;

import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import com.example.koun.dto.ItemNameAndUserIdDto;
import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.repository.ItemRepository;
import com.example.koun.repository.LikeRepository;
import com.example.koun.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final LikeRepository likeRepository;

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

    // 모든 아이템 조회
    @Transactional(readOnly = true)
    public List<ItemResponseDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
            .map(ItemResponseDto::new)
            .collect(Collectors.toList());
    }


//    // 아이템 삭제
//
//    public String deleteItemByName(String itemName) {
//        Item item = itemRepository.findByItemName(itemName)
//            .orElseThrow(() -> new EntityNotFoundException("Item not found with name: " + itemName));
//        itemRepository.delete(item);
//        return "아이템 id " + itemName + " 가 성공적으로 삭제되었습니다.";
//    }


//    // 특정 유저가 좋아요한  아이템
//    @Transactional(readOnly = true)
//    public List<ItemResponseDto> getUserLikeItems() {
//        List<Item> items = itemRepository.findAll();
//        return items.stream()
//            .map(ItemResponseDto::new)
//            .collect(Collectors.toList());
//    }
//
//
//    // 특정 사용자 좋아요 목록 조회
//    @Transactional(readOnly = true)
//    public List<ItemResponseDto> findAllLikesByUserId(Long userId) {
//        User user = userRepository.findById(userId)
//            .orElseThrow(() -> new IllegalArgumentException(
//                "사용자 ID [" + userId + "]에 해당하는 사용자를 찾을 수 없습니다."));
//
//        List<Like> likes = user.getLikes(); // User 엔티티에서 Like 리스트를 가져옴
//
//        // Like 엔티티를 ItemResponseDto로 변환
//        List<ItemResponseDto> itemResponseDtos = likes.stream()
//            .map(like -> new ItemResponseDto(
//                like.getItem())) // 가정: Like 엔티티에 getItem() 메서드가 있다고 가정합니다.
//            .collect(Collectors.toList());
//
//        return itemResponseDtos;
//    }
//
//
//    // 유저가 로그인하면 아이템 단건 조회 (좋아요 했는지)
//    @Transactional(readOnly = true)
//    public List<ItemResponseDto> findItemsByName(ItemNameAndUserIdDto itemNameAndUserIdDto) {
//        String itemName = itemNameAndUserIdDto.getItemName();
//        Long userId = itemNameAndUserIdDto.getUserId();
//
//        // 사용자가 해당 아이템을 좋아요 했는지 여부를 판단
//        boolean userLikes = checkUserLikes(userId, itemName);
//
//        if (!userLikes) {
//            return Collections.emptyList();
//        }
//
//        // 사용자가 좋아요한 아이템 목록 조회
//        User user = userRepository.findById(userId)
//            .orElseThrow(
//                () -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다 - UserId: " + userId));
//
//        Set<Long> likedItemIds = user.getLikes().stream()
//            .map(like -> like.getItem().getId())
//            .collect(Collectors.toSet());
//
//        // 아이템 이름으로 조회하여 사용자가 좋아요한 아이템만 선택
//        return itemRepository.findByItemName(itemName).stream()
//            .filter(item -> likedItemIds.contains(item.getId()))
//            .map(ItemResponseDto::new)
//            .collect(Collectors.toList());
//    }
//
//
//    // TODO: user 좋아요 여부 판단
//    @Transactional(readOnly = true)
//    public boolean checkUserLikes(Long userId, String itemName) {
//        User user = userRepository.findById(userId)
//            .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다" + userId));
//
//        Item item = itemRepository.findByItemName(itemName)
//            .orElseThrow(() -> new IllegalArgumentException("해당 아이템을 찾을 수 없습니다" + itemName));
//
//        // 사용자가 해당 아이템을 좋아요 했는지 여부를 판단
//        return likeRepository.existsByUserAndItem(user, item);
//    }

    // 인기 top1~10 조회

    public Page<ItemResponseDto> getTopLikes(Pageable pageable) {
        Page<Item> topItems = itemRepository.findTopLikedItems(pageable);
        return topItems.map(this::convertToDto);
    }

    private ItemResponseDto convertToDto(Item item) {
        // Item 객체를 ItemResponseDto 객체로 변환하는 로직
        return new ItemResponseDto(item);
    }

    // 신규 top1~10 조회
    public Page<ItemResponseDto> getNewTopLikes(Pageable pageable) {
        Page<Item> newTopItems = itemRepository.findNewTopLikedItems(pageable);
        return newTopItems.map(this::convertToDto2);
    }

    private ItemResponseDto convertToDto2(Item item) {
        // Item 객체를 ItemResponseDto 객체로 변환하는 로직
        return new ItemResponseDto(item);
    }









}