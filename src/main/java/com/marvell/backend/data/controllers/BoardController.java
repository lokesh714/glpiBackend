package com.marvell.backend.data.controllers;

import com.marvell.backend.data.entities.Board;
import com.marvell.backend.data.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards(@RequestParam String name){
        List<Board> allBoards = boardService.getAllBoards(name);
        return new ResponseEntity<>(allBoards, HttpStatus.OK);
    }
}
