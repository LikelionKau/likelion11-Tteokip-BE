package com.example.koun.controller;


import com.example.koun.domain.Board;
import com.example.koun.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }



    // 어떤 url로 접근할 건지
    @GetMapping("/admin")
    public String main(){
        return "board/adminWrite";

    }

    //html form태그에 있는 url과 일치해야 함
    @PostMapping("/admin/write")
    public String boardWriteDo(Board board){
        boardService.write(board);
        return "";

    }



}




