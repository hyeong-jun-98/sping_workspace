package com.academy.bootspa.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.bootspa.Exception.BoardException;
import com.academy.bootspa.model.domain.Board;

@Repository
public class HibernateBoardDAO  implements BoardDAO{

	@Autowired
	private HibernateBoardRepository boardRepository;
	
	@Override
	public List selectAll() {

		
		return boardRepository.findAll();
	}

	@Override
	public Board select(int board_id) {
		return boardRepository.findById(board_id).get();
	}

	@Override
	public void insert(Board board)  throws BoardException {
		Board result =  boardRepository.save(board);
		if(result == null) {
			throw new BoardException("하이버네이트로 등록 실패");
		}
	}

	@Override
	public void update(Board board)throws BoardException {
		Board result =  boardRepository.save(board);
		if(result == null) {
			throw new BoardException("하이버네이트로 등록 실패");
		}
	}

	@Override
	public void delete(Board board) {
		try {
			boardRepository.delete(board);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BoardException("하이버네이트로 삭제 실패", e);
		}
	}

	

}
