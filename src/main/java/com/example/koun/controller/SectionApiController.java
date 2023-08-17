package com.example.koun.controller;
import com.example.koun.dto.SectionFindResponseDto;
import com.example.koun.service.SectionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/sections")
@RequiredArgsConstructor
public class SectionApiController {
    private final SectionService sectionService;

    // 구역 단건 조회 --통과
    @GetMapping
    public ResponseEntity<SectionFindResponseDto> getSection(@RequestParam Long id) {
        SectionFindResponseDto section = sectionService.findSection(id);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }
    // 구역 삭제 --통과
    @DeleteMapping
    public ResponseEntity<Void> deleteSection(@RequestParam Long id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // 특정 콘서트에 해당되는 구역 리스트 조회 --통과
    @GetMapping("/item")
    public ResponseEntity<List<SectionFindResponseDto>> getSectionsByItemId(@RequestParam Long itemId) {
        List<SectionFindResponseDto> sections = sectionService.findSectionsByItemId(itemId);
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }

}
