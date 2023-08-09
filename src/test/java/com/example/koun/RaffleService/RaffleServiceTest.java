package com.example.koun.RaffleService;

import com.example.koun.domain.*;
import com.example.koun.dto.RaffleRequestDto;
import com.example.koun.dto.RaffleResponseDto;
import com.example.koun.repository.ItemRepository;
import com.example.koun.repository.OrderRepository;
import com.example.koun.repository.SectionRepository;
import com.example.koun.repository.UserRepository;
import com.example.koun.service.RaffleService;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RaffleServiceTest {

    @Autowired
    private RaffleService raffleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void joinRaffleAndFind() {
        // 1. 임시로 User, Item, Section 생성
        User user = User.builder()
                .userName("sangwon")
                .userEmail("zmdk12055@naver.com")
                .gender('M')
                .roleType(RoleType.USER)
                .build();
        // user 필드 설정
        userRepository.save(user);

        User user1 = User.builder()
                .userName("miyeon")
                .userEmail("aldus0123@naver.com")
                .gender('M')
                .roleType(RoleType.USER)
                .build();
        userRepository.save(user1);

        Item item = Item.builder()
                .itemName("lauv")
                .build();
        // item 필드 설정
        itemRepository.save(item);

        Item item1 = Item.builder()
                .itemName("브루노마스!!")
                .build();
        itemRepository.save(item1);

        System.out.println("itemmmmmmmmmmmmm" + item.getSections());

        Section section = Section.builder()
                .item(item)
                .build();
        // section 필드 설정
        sectionRepository.save(section);

        Section section1 = Section.builder()
                .item(item1)
                .build();
        sectionRepository.save(section1);

//        Order order = Order.builder()
//                .user(user)
//                .build();
//
//        orderRepository.save(order);

//        Order order1 = Order.builder()
//                .user(user1)
//                .build();
//
//        orderRepository.save(order1);
//
//        Order order2 = Order.builder()
//                .user(user1)
//                .build();
//
//        orderRepository.save(order2);

        System.out.println("1111111111111111");
        // 2. Raffle 생성
        RaffleRequestDto raffleRequestDto = RaffleRequestDto.builder()
                .raffleStatus("status")
                .raffleCount(1)
                .raffleDrawDate("2023-08-04 15:30")
                .userId(user.getId())
                .itemId(item.getId())
                .sectionId(section.getId())
                .build();

        RaffleRequestDto raffleRequestDto1 = RaffleRequestDto.builder()
                .raffleStatus("status")
                .raffleCount(1)
                .raffleDrawDate("2023-08-04 15:30")
                .userId(user.getId())
                .itemId(item1.getId())
                .sectionId(section1.getId())
                .build();

        RaffleRequestDto raffleRequestDto2 = RaffleRequestDto.builder()
                .raffleStatus("status")
                .raffleCount(1)
                .raffleDrawDate("2023-08-04 15:30")
                .userId(user1.getId())
                .itemId(item1.getId())
                .sectionId(section1.getId())
                .build();


        Long raffleId = raffleService.joinRaffle(raffleRequestDto);
        Long raffleId1 = raffleService.joinRaffle(raffleRequestDto1);
        Long raffleId2 = raffleService.joinRaffle(raffleRequestDto2);






        // 3. Raffle 조회
        //     RaffleResponseDto raffleResponseDto = raffleService.findRaffle(raffleId);
        List<RaffleResponseDto> userRaffles = raffleService.findRafflesByUserId(user.getId());
        List<RaffleResponseDto> itemRaffles = raffleService.findRaffleByItemId(item1.getId());
        System.out.println("유저 래플 응모 테스트:" + userRaffles);
        System.out.println("콘서트 래플 응모 테스트:" + itemRaffles);


        // 4. 결과 검증


        // 이외에 다른 필드들도 검증
    }
}
