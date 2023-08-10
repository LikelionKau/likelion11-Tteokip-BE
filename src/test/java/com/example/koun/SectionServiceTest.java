package com.example.koun;


import com.example.koun.Repository.ItemRepository;
import com.example.koun.Repository.SectionRepository;
import com.example.koun.Service.SectionService;
import com.example.koun.domain.Item;
import com.example.koun.domain.Section;
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
            .itemName("Lauv Concert")
            .artist("Lauv")
            .build();

        itemRepository.save(item);


        SectionSaveRequestDto sectionRequestDto = SectionSaveRequestDto.builder()
            .price(15000)
            .seatQuantity(20)
            .itemId(item.getId())
            .sectionName("L")
            .build();

        SectionSaveRequestDto sectionRequestDto2 = SectionSaveRequestDto.builder()
            .price(20000)
            .seatQuantity(30)
            .itemId(item.getId())
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


    }




}
