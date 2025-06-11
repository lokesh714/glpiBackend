package com.marvell.backend.data.repositories;

import com.marvell.backend.data.dto.BoardStateDTO;
import com.marvell.backend.data.entities.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BoardModelRepository extends JpaRepository<BoardModel,Integer> {

    @Query("SELECT bm FROM BoardModel bm " +
           "JOIN Board b ON bm.id = b.pluginGenericobjectBoardmodelsId " +
           "JOIN BoardType bt ON b.pluginGenericobjectBoardtypesId = bt.id " +
           "WHERE bt.name = :boardTypeName")
    List<BoardModel> findBoardModelsByBoardTypeName(@Param("boardTypeName") String boardTypeName);

}
