package com.marvell.backend.data.repositories;

import com.marvell.backend.data.entities.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTypeRepository extends JpaRepository<BoardType,Integer> {

     BoardType findByName(String name);
}
