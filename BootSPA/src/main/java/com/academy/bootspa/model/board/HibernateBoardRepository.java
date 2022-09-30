package com.academy.bootspa.model.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.bootspa.model.domain.Board;

public interface HibernateBoardRepository extends JpaRepository<Board, Integer> {

	
	
	
}
