package com.example.koun.controller.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardWriteController{

    // 어떤 url로 접근할 건지
    @GetMapping("/board/write")
    public String main(){
        return "board/boardWrite";

    }


}




