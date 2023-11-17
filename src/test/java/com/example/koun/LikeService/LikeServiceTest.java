//package com.example.koun.LikeService;
//
//import com.example.koun.domain.Item;
//import com.example.koun.domain.User;
//import com.example.koun.dto.ItemRequestDto;
//import com.example.koun.dto.LikeRequestDto;
//import com.example.koun.dto.LikeResponseDto;
//import com.example.koun.repository.ItemRepository;
//import com.example.koun.repository.UserRepository;
//import com.example.koun.service.ItemService;
//import com.example.koun.service.LikeService;
//import java.time.LocalDateTime;
//import java.util.List;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//
//
//
//@SpringBootTest
//public class LikeServiceTest {
//
//    @Autowired
//    private ItemService itemService;
//
//
//    @Autowired
//    private LikeService likeService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    @Test
//    public void createLikeAndFind() {
//        // 임시 User 생성
//        LocalDateTime userBirth = LocalDateTime.of(1990, 8, 11, 0, 0);
//        User user = User.builder()
//            .userName("sangwon")
//            .phoneNum("3939480")
//            .userEmail("zmdk12055@naver.com")
//            .gender('M')
//            .userAddress("의정부시")
//            .userBirth(userBirth)
//            .build();
//        userRepository.save(user);
//
//        System.out.println("user 조회: " + user.getUserName());
//
//        // 아이템 생성 및 저장
//        ItemRequestDto itemRequestDto = ItemRequestDto.builder()
//            .raffleQuantity(100)
//            .artist("John Smith")
//            .venue("Sample Venue")
//            .likeNum(200)
//            .itemName("Sample Item")
//            .description("Sample Description")
//            .build();
//
//        Long itemId = itemService.joinItem(itemRequestDto);
//
//        System.out.println("콘서트 생성: " + itemRequestDto.getItemName());
//
//
//        // 찜 생성 및 저장
//        LikeRequestDto likeRequestDto = LikeRequestDto.builder()
//            .itemName("Sample Item")
//            .artist("John Smith")
//            .dateTime("2023-09-24 12:00:00")
//            .venue("Sample Venue")
//            .raffleState("Open")
//            .build();
//
//        Long likeId = likeService.joinLike(likeRequestDto);
//
//        System.out.println("Like created for Item: " + likeRequestDto.getItemName());
//
//        // 3. Like 조회
//
//        // 찜 아이디로 아이템 조회
//        LikeResponseDto foundLike = likeService.findLikeById(likeId);
//        System.out.println("Find Like by ID: " + foundLike.getId());
//
//        // 아이템 이름으로 아이템 조회
//        LikeResponseDto foundLikeByName = likeService.findLikesByName("Sample Item");
//        System.out.println("Find Like by Item Name: " + foundLikeByName.getItem());
//
//        // 전체 아이템 조회
//        List<LikeResponseDto> allLikes = likeService.getAllLikes();
//        for (LikeResponseDto like : allLikes) {
//            System.out.println("Find All Likes: " + like.getItem());
//        }
//    }
//}
