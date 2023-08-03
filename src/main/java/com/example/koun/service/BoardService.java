package com.example.koun.service.board;

import com.example.koun.domain.Board;
import com.example.koun.repository.board.BoardWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardWriteService {

    @Autowired
    private BoardWriteRepository boardWriteRepository;

    public void write(Board board){
        boardWriteRepository.save(board);


    }

}
