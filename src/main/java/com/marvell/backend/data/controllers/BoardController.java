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
import org.springframework.data.domain.Page;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    
    @GetMapping
    public ResponseEntity<List<BoardModel>> getAllBoards(@RequestParam String name){
        List<BoardModel> allBoardModels = boardService.getAllBoards(name);
        return new ResponseEntity<>(allBoardModels, HttpStatus.OK);
    }


    @GetMapping("/model/{boardModelId}")
    public ResponseEntity<Page<BoardStateDTO>> getBoardStates(
            @PathVariable Long boardModelId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(boardService.getBoardNamesAndStatesByModelId(boardModelId, page, size));
    }

    @GetMapping("/model")
    public ResponseEntity<Page<BoardStateDTO>> getAllBoardStates(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    return ResponseEntity.ok(boardService.getAllBoardNamesAndStates(page, size));
}

}
