package com.example.koun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String s3Start() {
        return "redirect:https://koun-s3.s3.ap-northeast-2.amazonaws.com/likelion11-Tteokip-FE-main/html/main.html";
    }

}
