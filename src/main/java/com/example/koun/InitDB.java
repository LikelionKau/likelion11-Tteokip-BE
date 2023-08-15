package com.example.koun;


import com.example.koun.domain.Item;
import com.example.koun.domain.Section;
import com.example.koun.domain.User;
import com.example.koun.repository.ItemRepository;
import com.example.koun.repository.SectionRepository;
import com.example.koun.repository.UserRepository;
import com.example.koun.service.RaffleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final RaffleService raffleService;
        private final UserRepository userRepository;
        private final SectionRepository sectionRepository;
        private final ItemRepository itemRepository;
        public void dbInit1(){


            User user = User.builder()
                    .userName("상원")
                    .userEmail("zmdk1205@naver.")
                    .build();
            userRepository.save(user);



            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse("2323-08-11 16:30", formatter);



            Item item = Item.builder()
                    .itemName("라우브")
                    .dateTime(dateTime)
                    .build();
            itemRepository.save(item);

            Item item1 = Item.builder()
                    .itemName("브루노마스")
                    .dateTime(dateTime)
                    .build();
            itemRepository.save(item1);

            Section section = Section.builder()
                    .sectionName("스탠딩-가")
                    .seatQuantity(100)
                    .item(item)
                    .build();
            sectionRepository.save(section);

            Section section1 = Section.builder()
                    .sectionName("지정석-나")
                    .seatQuantity(200)
                    .item(item)
                    .build();
            sectionRepository.save(section1);






        }
    }




}
