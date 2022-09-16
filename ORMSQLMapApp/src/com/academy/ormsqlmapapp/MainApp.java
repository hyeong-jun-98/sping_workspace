package com.academy.ormsqlmapapp;

import com.academy.ormsqlmapapp.model.Board.BoardDAO;
import com.academy.ormsqlmapapp.model.domain.Board;
import com.academy.ormsqlmapapp.model.domain.HibernateBoardDAO;

public class MainApp {

	public static void main(String[] args) {

		
		BoardDAO boardDAO = new HibernateBoardDAO();
		
//		boardDAO.selectAll();
		
		/*
		Board board = new Board();
		board.setTitle("하이버네이트");
		board.setWriter("coupangman");
		board.setContent("내용없음");
		
		boardDAO.insert(board);
		*/
		/*
		Board board = new Board();
		board.setBoard_id(3);
		board.setTitle("수정");
		board.setWriter("수정gman");
		board.setContent("내용수정");
		
		boardDAO.update(board);
		*/
		Board board = new Board();
		board.setBoard_id(3);
		boardDAO.delete(board);
		
	}

}
