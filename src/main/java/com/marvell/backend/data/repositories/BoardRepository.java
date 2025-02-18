package com.marvell.backend.data.repositories;

import com.marvell.backend.data.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {

    List<Board> findByPluginGenericobjectBoardtypesId(int id);
}
