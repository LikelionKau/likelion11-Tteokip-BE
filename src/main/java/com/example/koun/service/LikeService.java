package com.example.koun.service;


import com.example.koun.domain.Item;
import com.example.koun.domain.Like;
import com.example.koun.domain.User;
import com.example.koun.dto.LikeRequestDto;
import com.example.koun.dto.LikeResponseDto;
import com.example.koun.repository.LikeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {

    private final LikeRepository likeRepository;

    // 새로운 찜 등록
    @Transactional
    public Long joinLike(LikeRequestDto likeRequestDto){
        Like like = likeRequestDto.toEntity();
        return likeRepository.save(like).getId();
    }


    // 모든 찜목록 조회
    @Transactional(readOnly = true)
    public List<LikeResponseDto> getAllLikes(){
        List<Like> likes = likeRepository.findAll();
        return likes.stream()
            .map(LikeResponseDto::new)
            .collect(Collectors.toList());
    }

    // 아이템 이름으로 찜 조회
    @Transactional(readOnly = true)
    public LikeResponseDto findLikesByName(String itemName) {
        Like like = likeRepository.findByItemName(itemName)
            .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다 name: " + itemName));

        return new LikeResponseDto(like);
    }

    // 아이템 아이디로 찜 조회
    public LikeResponseDto findLikeById(Long likeId) {
        Like like = likeRepository.findById(likeId)
            .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id:" + likeId));

        return new LikeResponseDto(like);

    }


    // 찜 삭제
    public void deleteItem(Long likeId){
        Like like = likeRepository.findById(likeId)
            .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id=" + likeId));
        likeRepository.delete(like);
    }


}
