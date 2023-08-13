package com.example.koun.itemService;


import com.example.koun.domain.RoleType;
import com.example.koun.domain.User;
import com.example.koun.dto.ItemRequestDto;
import com.example.koun.dto.ItemResponseDto;
import com.example.koun.repository.UserRepository;
import com.example.koun.service.ItemService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class ItemServiceTest {


    @Autowired
    private ItemService itemService;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void createItemAndFind() {
        // 1. 임시로 User 생성

        LocalDateTime userBirth = LocalDateTime.of(1990, 8, 11, 0, 0); // 예시로 1990년 8월 11일 00:00
        User user = User.builder()
            .userName("sangwon")
            .phoneNum("3939480")
            .userEmail("zmdk12055@naver.com")
            .gender('M')
            .userAddress("의정부시")
            .userBirth(userBirth)
            .roleType(RoleType.USER)
            .build();
        userRepository.save(user);

        System.out.println("user 조회: "+ user);

        // 2. Item 생성 및 저장
        ItemRequestDto itemRequestDto = ItemRequestDto.builder()
            .raffleQuantity(100)
            .artist("John Smith")
            .venue("Sample Venue")
            .ticketPrice(50)
            .likeNum(200)
            .itemName("Sample Item")
            .description("Sample Description")
            .build();

        Long itemId = itemService.joinItem(itemRequestDto);

        System.out.println("콘서트 생성"+ itemRequestDto);

        // 3. Item 조회
        ItemResponseDto foundItem = itemService.findById(itemId);
        System.out.println("콘서트 아이디로 아이템 조회"+ foundItem);

        // 4. 결과 검증
//        assertEquals(itemRequestDto.getRaffleQuantity(), foundItem.getRaffleQuantity());
//        assertEquals(itemRequestDto.getArtist(), foundItem.getArtist());
        // 나머지 필드들도 검증

        // 5. 이외에 필요한 검증 작업 수행
    }
}