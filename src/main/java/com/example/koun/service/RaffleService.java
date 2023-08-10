package com.example.koun.service;

import com.example.koun.domain.*;
import com.example.koun.dto.RaffleSaveRequestDto;
import com.example.koun.dto.RaffleFindResponseDto;
import com.example.koun.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RaffleService {

    private final UserRepository userRepository;
    private final RaffleRepository raffleRepository;
    private final ItemRepository itemRepository;
    private final SectionRepository sectionRepository;


    //DB에 저장
    @Transactional
    public Long joinRaffle(RaffleSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + requestDto.getUserId()));
        Item item = itemRepository.findById(requestDto.getItemId())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 상품이 없습니다. id=" + requestDto.getItemId()));
        Section section = sectionRepository.findById(requestDto.getSectionId())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 섹션이 없습니다. id=" + requestDto.getSectionId()));

        Raffle raffle = requestDto.toEntity(user, item, section);

        return raffleRepository.save(raffle).getId();
    }


    //래플 id로 래플 조회
    @Transactional(readOnly = true)
    public RaffleFindResponseDto findRaffle(Long id) {
        Raffle entity = raffleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 응모가 없습니다. id=" + id));

        return new RaffleFindResponseDto(entity);
    }

    //userId, itemId로 래플 조회
    @Transactional(readOnly = true)
    public RaffleFindResponseDto findRaffleByUserIdAndItemId(Long userId, Long itemId) {
        Raffle raffle = raffleRepository.findByUserIdAndItemId(userId, itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 조건에 맞는 래플이 없습니다. userId=" + userId + ", itemId=" + itemId));

        return new RaffleFindResponseDto(raffle);
    }


    //raffleStatus 업데이트
    @Transactional
    public void updateRaffleStatus(Long raffleId, String newStatus) {
        Raffle raffle = raffleRepository.findById(raffleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 응모가 없습니다. id=" + raffleId));

        raffle.winRaffleStatus(newStatus);
    }


    //user가 응모한 래플 리스트 조회
    public List<RaffleFindResponseDto> findRafflesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userId));

        List<Raffle> raffles = user.getRaffles(); // User 엔티티에서 Raffle 리스트를 가져옴

        // Raffle 엔티티 리스트를 RaffleResponseDto 리스트로 변환
        List<RaffleFindResponseDto> raffleFindResponseDtos = raffles.stream()
                .map(RaffleFindResponseDto::new)
                .collect(Collectors.toList());

        return raffleFindResponseDtos;
    }

    //콘서트에 응모된 래플 리스트 조회
    public List<RaffleFindResponseDto> findRaffleByItemId(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 콘서트가 없습니다, id=" + itemId));

        List<Raffle> raffles = item.getRaffles();

        List<RaffleFindResponseDto> raffleFindResponseDtos = raffles.stream()
                .map(RaffleFindResponseDto::new)
                .collect(Collectors.toList());
        return raffleFindResponseDtos;


    }

    //콘서트 구역에 응모된 리스트 조회
    public List<RaffleFindResponseDto> findRaffleBySectionId(Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 콘서트 구역이 없습니다, id=" + sectionId));

        List<Raffle> raffles = section.getRaffles();

        List<RaffleFindResponseDto> raffleFindResponseDtos = raffles.stream()
                .map(RaffleFindResponseDto::new)
                .collect(Collectors.toList());
        return raffleFindResponseDtos;


    }

    //응모 삭제
    @Transactional
    public void deleteRaffle(Long raffleId) {

        Raffle raffle = raffleRepository.findById(raffleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 응모가 없습니다. id=" + raffleId));


        raffleRepository.delete(raffle);
    }


}