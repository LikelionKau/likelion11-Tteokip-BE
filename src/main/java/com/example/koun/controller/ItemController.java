package com.example.koun.controller;

import com.example.koun.dto.ItemRequestDto;
import com.example.koun.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/section")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/register")
    public String registerForm() {
        return "itemAndSection";
    }
    @PostMapping("/register/save")
    public String saveSection(ItemRequestDto requestDto) {
        System.out.println("테스트 dto 이름"+requestDto.getItemName());
        itemService.joinItem(requestDto);
        return "itemAndSection";
    }
}
