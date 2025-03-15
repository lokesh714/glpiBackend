package com.marvell.backend.data.controllers;

import com.marvell.backend.data.dto.BoardStateDTO;
import com.marvell.backend.data.entities.Board;
import com.marvell.backend.data.entities.BoardModel;
import com.marvell.backend.data.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<BoardModel>> getAllBoards(@RequestParam String name){
        List<BoardModel> allBoardModels = boardService.getAllBoards(name);
        return new ResponseEntity<>(allBoardModels, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/model/{boardModelId}")
    public List<BoardStateDTO> getBoardNamesAndStates(@PathVariable Long boardModelId) {
        return boardService.getBoardNamesAndStatesByModelId(boardModelId);
    }
}
