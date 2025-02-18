package com.marvell.backend.data.repositories;

import com.marvell.backend.data.entities.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardModelRepository extends JpaRepository<BoardModel,Integer> {
}
