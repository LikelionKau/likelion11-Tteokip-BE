package com.example.koun.controller;

import com.example.koun.dto.RaffleFindResponseDto;
import com.example.koun.dto.RaffleResultResponseDto;
import com.example.koun.dto.RaffleSaveRequestDto;
import com.example.koun.service.RaffleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/raffles")
public class RaffleController {

    private final RaffleService raffleService;


    // 래플 생성
    @PostMapping
    public ResponseEntity<Long> createRaffle(@RequestBody RaffleSaveRequestDto requestDto) {
        Long raffleId = raffleService.joinRaffle(requestDto);
        return new ResponseEntity<>(raffleId, HttpStatus.CREATED);
    }

    // 특정 사용자가 응모한 래플 리스트 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RaffleFindResponseDto>> getRafflesByUserId(@PathVariable Long userId) {
        List<RaffleFindResponseDto> raffles = raffleService.findRafflesByUserId(userId);
        return new ResponseEntity<>(raffles, HttpStatus.OK);
    }

    // 래플 단건 조회
    @GetMapping("/{raffleId}")
    public ResponseEntity<RaffleFindResponseDto> getRaffle(@PathVariable Long raffleId) {
        RaffleFindResponseDto raffle = raffleService.findRaffle(raffleId);
        return new ResponseEntity<>(raffle, HttpStatus.OK);
    }

    //래플 결과 팝업 조회
    @GetMapping("/{raffleId}/result")
    public ResponseEntity<RaffleResultResponseDto> getRaffleResult(@PathVariable Long raffleId) {
        RaffleResultResponseDto raffle = raffleService.findRaffleResult(raffleId);
        return new ResponseEntity<>(raffle, HttpStatus.OK);
    }


}
