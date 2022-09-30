package com.academy.bootspa.model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.bootspa.Exception.BoardException;
import com.academy.bootspa.model.domain.Board;
@Repository
public class MybatisBoardDAO implements BoardDAO {

	@Autowired
	private MybatisBoardMapper boardMapper;

	@Override
	public List selectAll() {
		return boardMapper.selectAll();
	}

	@Override
	public Board select(int board_id) {
		return boardMapper.select(board_id);
	}

	@Override
	public void insert(Board board)  throws BoardException{
		int result = boardMapper.insert(board);
		if (result == 0) {
			throw new BoardException("등록 실패");
		}
		
	}

	@Override
	public void update(Board board) throws BoardException {
		int result = boardMapper.update(board);
		if(result ==0 ) {
			throw new BoardException("수정 실패");
		}
		
	}

	@Override
	public void delete(Board board)throws BoardException{
		int result = boardMapper.delete(board);
		if(result ==0 ) {
			throw new BoardException("삭제 실패");
		}
		
	}
	
	

}
