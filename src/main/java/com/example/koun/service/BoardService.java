package com.example.koun.service;

import com.example.koun.domain.Board;
import com.example.koun.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

//    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void write(Board board){
        boardRepository.save(board);


    }

}
