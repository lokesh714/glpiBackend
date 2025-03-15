package com.marvell.backend.data.repositories;

import com.marvell.backend.data.dto.BoardStateDTO;
import com.marvell.backend.data.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {

    List<Board> findByPluginGenericobjectBoardtypesId(int id);

    // Custom query to fetch board name and state name by board model ID
    @Query("SELECT new com.marvell.backend.data.dto.BoardStateDTO(b.name, s.completename) " +
           "FROM Board b " +
           "JOIN GlpiState s ON b.statesId = s.id " +
           "WHERE b.pluginGenericobjectBoardmodelsId = :boardModelId")
    List<BoardStateDTO> findBoardNamesAndStatesByModelId(@Param("boardModelId") Long boardModelId);
}
