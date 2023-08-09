package com.example.koun.service;

import com.example.koun.domain.*;
import com.example.koun.dto.RaffleRequestDto;
import com.example.koun.dto.RaffleResponseDto;
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
    private final OrderRepository orderRepository;


    //DB에 저장
    @Transactional
    public Long joinRaffle(RaffleRequestDto requestDto) {
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


    //조회
    @Transactional(readOnly = true)
    public RaffleResponseDto findRaffle(Long id) {
        Raffle entity = raffleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 응모가 없습니다. id=" + id));

        return new RaffleResponseDto(entity);
    }


    //raffleStatus 업데이트
    @Transactional
    public void updateRaffleStatus(Long raffleId, String newStatus) {
        Raffle raffle = raffleRepository.findById(raffleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 응모가 없습니다. id=" + raffleId));

        raffle.winRaffleStatus(newStatus);
    }


    //user가 응모한 래플 리스트 조회
    public List<RaffleResponseDto> findRafflesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userId));

        List<Raffle> raffles = user.getRaffles(); // User 엔티티에서 Raffle 리스트를 가져옴

        // Raffle 엔티티 리스트를 RaffleResponseDto 리스트로 변환
        List<RaffleResponseDto> raffleResponseDtos = raffles.stream()
                .map(RaffleResponseDto::new)
                .collect(Collectors.toList());

        return raffleResponseDtos;
    }

    //콘서트에 응모된 래플 리스트 조회
    public List<RaffleResponseDto> findRaffleByItemId(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 콘서트가 없습니다, id=" + itemId));

        List<Raffle> raffles = item.getRaffles();

        List<RaffleResponseDto> raffleResponseDtos = raffles.stream()
                .map(RaffleResponseDto::new)
                .collect(Collectors.toList());
        return raffleResponseDtos;


    }

    //콘서트 구역에 응모된 리스트 조회
    public List<RaffleResponseDto> findRaffleBySectionId(Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 콘서트 구역이 없습니다, id=" + sectionId));

        List<Raffle> raffles = section.getRaffles();

        List<RaffleResponseDto> raffleResponseDtos = raffles.stream()
                .map(RaffleResponseDto::new)
                .collect(Collectors.toList());
        return raffleResponseDtos;


    }
}