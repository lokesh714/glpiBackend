package com.marvell.backend.data.services;

import com.marvell.backend.data.dto.BoardStateDTO;
import com.marvell.backend.data.entities.BoardModel;
import com.marvell.backend.data.exceptions.ResourceNotFoundException;
import com.marvell.backend.data.repositories.BoardModelRepository;
import com.marvell.backend.data.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {


    private final BoardModelRepository boardModelRepository;

    private final BoardRepository boardRepository;

    public List<BoardModel> getAllBoards(String name){
        log.info("getting All Boards");
        List<BoardModel> boardModels=boardModelRepository.findBoardModelsByBoardTypeName(name);
        if(boardModels.size()!=0){
            return boardModels;
        }
        throw new ResourceNotFoundException("Board Models Not Found Under BoardType: "+name);
    }

    // Get board names and states with pagination
    public Page<BoardStateDTO> getBoardNamesAndStatesByModelId(Long boardModelId, int page, int size) {
        log.info("Fetching paginated board states for Model ID: {}, Page: {}, Size: {}", boardModelId, page, size);
        return boardRepository.findBoardNamesAndStatesByModelId(boardModelId, PageRequest.of(page, size));
    }



}
