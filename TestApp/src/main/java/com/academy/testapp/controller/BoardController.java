package com.academy.testapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.academy.testapp.exception.BoardException;
import com.academy.testapp.model.board.BoardService;
import com.academy.testapp.model.domain.Board;
import com.academy.testapp.util.Message;



@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/board/writeform")
	public ModelAndView getForm() {
		ModelAndView mav = new ModelAndView("board/write");

		return mav;
	}

	@PostMapping("/board/regist")
	@ResponseBody
	public ResponseEntity<Message> regist(@RequestBody Board board) {
		boardService.insert(board);
		Message message = new Message(1, "등록 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}
	
	
	
	
	
	@ExceptionHandler(BoardException.class)
	public ResponseEntity<Message> handle(BoardException e) {
		Message message = new Message(0, "등록 실패");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}
	
}
