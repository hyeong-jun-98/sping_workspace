package com.academy.testapp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.testapp.exception.BoardException;
import com.academy.testapp.model.board.BoardDAO;
import com.academy.testapp.model.board.BoardMapper;
import com.academy.testapp.model.domain.Board;

@Repository
public class MybatisBoardDAO implements BoardDAO {
	@Autowired
	private BoardMapper boardMapper; // sqlSessionTemplate 대신 사용한다.

	@Override
	public List selectAll() {

		return boardMapper.selectAll();
	}

	@Override
	public Board select(int board_id) {
		
		return boardMapper.select(board_id);
	}

	@Override
	public void insert(Board board) throws BoardException {
		int result = boardMapper.insert(board);
		if (result == 0) {
			throw new BoardException("등록 실패");
		}
	}

	@Override
	public void update(Board board) throws BoardException {
		int result = boardMapper.update(board);
		if (result == 0) {
			throw new BoardException("수정 실패");
		}

	}

	@Override
	public void delete(Board board) throws BoardException {
		int result = boardMapper.delete(board);
		if (result == 0) {
			throw new BoardException("삭제 실패");
		}

	}

}
