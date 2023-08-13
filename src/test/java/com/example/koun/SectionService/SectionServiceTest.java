package com.example.koun.SectionService;


import com.example.koun.repository.ItemRepository;
import com.example.koun.service.SectionService;
import com.example.koun.domain.Item;
import com.example.koun.dto.SectionFindResponseDto;
import com.example.koun.dto.SectionSaveRequestDto;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SectionServiceTest {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SectionService sectionService;
    @Test
    public void joinSectionAndFind() {

        Item item = Item.builder()
            .itemName("임영웅의 영웅티비")
            .artist("임영웅")
            .build();

        itemRepository.save(item);


        SectionSaveRequestDto sectionRequestDto = SectionSaveRequestDto.builder()
            .price(15000)
            .seatQuantity(20)
            .itemName(item.getItemName())
            .sectionName("L")
            .build();

        SectionSaveRequestDto sectionRequestDto2 = SectionSaveRequestDto.builder()
            .price(20000)
            .seatQuantity(30)
            .itemName(item.getItemName())
            .sectionName("A")
            .build();




        Long sectionId1 = sectionService.joinSection(sectionRequestDto);
        Long sectionId2 = sectionService.joinSection(sectionRequestDto2);



        //콘서트 아이디에 해당하는 구역 조회
        List<SectionFindResponseDto> itemSections = sectionService.findSectionsByItemId(item.getId());
        System.out.println("콘서트 구역 테스트" + itemSections);

        //좌석의 가격 업데이트
        sectionService.updateSectionPrice(sectionId1,30000);

        //좌석수 업데이트
        sectionService.updateSectionSeatQuantity(sectionId2,40);

        //좌석 삭제
        sectionService.deleteSection(sectionId1);


    }




}
