package com.example.koun.service;

import com.example.koun.repository.ItemRepository;
import com.example.koun.repository.SectionRepository;
import com.example.koun.domain.Item;
import com.example.koun.domain.Section;
import com.example.koun.dto.SectionFindResponseDto;
import com.example.koun.dto.SectionSaveRequestDto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {

    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final SectionRepository sectionRepository;


    //생성
    @Transactional
    public Long joinSection(SectionSaveRequestDto requestDto) {
        Item item = itemRepository.findById(requestDto.getItemId())
            .orElseThrow(
                () -> new IllegalArgumentException("해당 콘서트가 없습니다.")
            );
        Section section = requestDto.toEntity(item);

        return sectionRepository.save(section).getId();

    }

    //조회
//    @Transactional
////    public SectionResponseDto findSection(Long id) {
////        Section entity = sectionRepository.findById(id)
////            .orElseThrow(() -> new IllegalArgumentException("해당 구역이 없습니다. id=" + id));
////        return new SectionResponseDto(entity);
////    }

    //콘서트에 해당하는 구역 리스트 조회
    @Transactional
    public List<SectionFindResponseDto> findSectionsByItemId(Long itemId) {
        Item item = itemRepository.findById(itemId)
            .orElseThrow(() -> new IllegalArgumentException("해당 콘서트는 없습니다. id=" + itemId));
        List<Section> sections = item.getSections();

        //sectionResponseDtos라는 리스트 만들기
        List<SectionFindResponseDto> sectionResponseDtos = sections.stream()
            .map(section -> new SectionFindResponseDto(section))
            .collect(Collectors.toList());

        return sectionResponseDtos;
    }

    //구역의 가격 업데이트
    @Transactional
    public void updateSectionPrice(Long sectionId, int newPrice) {
        Section section = sectionRepository.findById(sectionId)
            .orElseThrow(() -> new IllegalArgumentException("해당 구역이 없습니다. id=" + sectionId));

        section.newSectionPrice(newPrice);
    }
    //구역의 좌석수 업데이트
    @Transactional
    public void updateSectionSeatQuantity(Long sectionId, int newQuantity) {
        Section section = sectionRepository.findById(sectionId)
            .orElseThrow(() -> new IllegalArgumentException("해당 구역이 없습니다. id=" + sectionId));

        section.newSectionSeatQuantity(newQuantity);
    }

    //구역 삭제
    @Transactional
    public void deleteRaffle(Long sectionId) {

        Section section = sectionRepository.findById(sectionId)
            .orElseThrow(() -> new IllegalArgumentException("해당 구역이 없습니다. id=" + sectionId));


        sectionRepository.delete(section);
    }




}
