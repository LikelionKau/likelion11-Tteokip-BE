package com.example.koun.controller;

import com.example.koun.dto.SectionFindResponseDto;
import com.example.koun.dto.SectionSaveRequestDto;
import com.example.koun.service.SectionService;
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
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    // 구역 생성
    @PostMapping
    public ResponseEntity<Long> createSection(@RequestBody SectionSaveRequestDto requestDto) {
        Long sectionId = sectionService.joinSection(requestDto);
        return new ResponseEntity<>(sectionId, HttpStatus.CREATED);
    }

    // 구역 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<SectionFindResponseDto> getSection(@PathVariable Long id) {
        SectionFindResponseDto section = sectionService.findSection(id);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    // 구역 가격 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSectionPrice(@PathVariable Long id, @RequestBody int newPrice) {
        sectionService.updateSectionPrice(id, newPrice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 구역별 좌석수 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSectionQuantity(@PathVariable Long id, @RequestBody int newSectionSeatQuantity) {
        sectionService.updateSectionSeatQuantity(id, newSectionSeatQuantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 구역 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 특정 콘서트에 해당되는 구역 리스트 조회
    @GetMapping("/items/{itemId}")
    public ResponseEntity<List<SectionFindResponseDto>> getSectionsByItemId(@PathVariable Long itemId) {
        List<SectionFindResponseDto> sections = sectionService.findSectionsByItemId(itemId);
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }





}
