package com.marvell.backend.data.repositories;

import com.marvell.backend.data.dto.BoardStateDTO;
import com.marvell.backend.data.entities.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    // Get boards by type (No pagination needed)
    List<Board> findByPluginGenericobjectBoardtypesId(int id);

    // Get board names and states with pagination
    @Query("SELECT new com.marvell.backend.data.dto.BoardStateDTO(b.name, s.completename) " +
           "FROM Board b " +
           "JOIN GlpiState s ON b.statesId = s.id " +
           "WHERE b.pluginGenericobjectBoardmodelsId = :boardModelId")
    Page<BoardStateDTO> findBoardNamesAndStatesByModelId(@Param("boardModelId") Long boardModelId, Pageable pageable);

    @Query("SELECT new com.marvell.backend.data.dto.BoardStateDTO(b.name, s.completename) " +
       "FROM Board b " +
       "JOIN GlpiState s ON b.statesId = s.id")
    Page<BoardStateDTO> findAllBoardNamesAndStates(Pageable pageable);

}
