package com.example.koun.controller;


import com.example.koun.dto.SectionSaveRequestDto;
import com.example.koun.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/section")
@RequiredArgsConstructor
public class SectionController {
    private final SectionService sectionService;
    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }
    @PostMapping("/save")
    public String saveSection(SectionSaveRequestDto requestDto) {
        sectionService.joinSection(requestDto);
        return "register";
    }
}