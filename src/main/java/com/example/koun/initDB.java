package com.example.koun;


import com.example.koun.domain.Item;
import com.example.koun.domain.Section;
import com.example.koun.repository.ItemRepository;
import com.example.koun.repository.SectionRepository;
import com.example.koun.service.SectionService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class initDB {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final SectionService sectionService;
        private final ItemRepository itemRepository;
        private final SectionRepository sectionRepository;
        public void dbInit1(){

            Item item1 = Item.builder()
                .itemName("임영웅의 영웅티비")
                .artist("임영웅")
                .build();

            Item item2 = Item.builder()
                .itemName("라우브의 라우브티비")
                .artist("라우브")
                .build();

            itemRepository.save(item1);
            itemRepository.save(item2);


        }



    }


}
