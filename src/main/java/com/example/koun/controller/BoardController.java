package com.example.koun.controller.board;


import com.example.koun.domain.Board;
import com.example.koun.service.board.BoardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardWriteController{

    private BoardWriteService boardWriteService;

    @Autowired
    public BoardWriteController(BoardWriteService boardWriteService) {
        this.boardWriteService = boardWriteService;
    }



    // 어떤 url로 접근할 건지
    @GetMapping("/admin")
    public String main(){
        return "board/adminWrite";

    }

    //html form태그에 있는 url과 일치해야 함
    @PostMapping("/admin/write")
    public String boardWriteDo(Board board){
        boardWriteService.write(board);
        return "";

    }



}




