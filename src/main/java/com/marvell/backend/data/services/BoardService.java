package com.marvell.backend.data.services;

import com.marvell.backend.data.entities.Board;
import com.marvell.backend.data.entities.BoardType;
import com.marvell.backend.data.exceptions.ResourceNotFoundException;
import com.marvell.backend.data.repositories.BoardRepository;
import com.marvell.backend.data.repositories.BoardTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardTypeRepository boardTypeRepository;

    private final BoardRepository boardRepository;

    public List<Board> getAllBoards(String name){
        log.info("getting All Boards");
        BoardType boardType = boardTypeRepository.findByName(name);
        if(boardType!=null){
            return boardRepository.findByPluginGenericobjectBoardtypesId(boardType.getId());
        }
        throw new ResourceNotFoundException("Boards Not Found");
    }
}
