package com.academy.bootspa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.bootspa.Exception.BoardException;
import com.academy.bootspa.model.board.BoardService;
import com.academy.bootspa.model.domain.Board;
import com.academy.bootspa.util.Message;

@RestController
@RequestMapping("/rest")
public class RestBoardController {
	
	@Autowired
	private BoardService boardService;

	@PostMapping("/serial/board")
	public ResponseEntity<Message> registByParam (Board board) {
		System.out.println("시리얼 화 받음" + board);
		boardService.insert(board);
		Message message = new Message(1, "registBySerial 등록 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message> (message, HttpStatus.OK);
		
		return entity;
	}
	
	// json으로 날라온 파일을 DTO로 넣어준디 @requestBody
	@PostMapping("/json/board")
	public ResponseEntity<Message> registByJson ( @RequestBody Board board) {
		System.out.println("registByJson" + board);
		boardService.insert(board);
		Message message = new Message(1, "registBySerial 등록 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message> (message, HttpStatus.OK);

		return entity;
	}
	
	@GetMapping("/board")
	public List  getList() {
	
		return boardService.selectAll();
	}
	
	@GetMapping("/board/{board_id}")
	public Board getOne(@PathVariable("board_id") int board_id) {
		
		return boardService.select(board_id);
	}
	
	
	@PutMapping("/board")
	public ResponseEntity<Message> update (Board board) {
		
		boardService.update(board);
		Message message = new Message(1, "수정성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message> (message, HttpStatus.OK);
		
		return entity;
	}
	
	@DeleteMapping("/board")
	public ResponseEntity<Message> delete (Board board) {
		
		boardService.delete(board);
		Message message = new Message(1, "삭제성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message> (message, HttpStatus.OK);
		
		
		return entity;
	}
	
	
	@ExceptionHandler(BoardException.class)
	public ResponseEntity<Message> handle(BoardException e) {
		
		Message message = new Message(0, e.getMessage());
		ResponseEntity<Message> entity = new ResponseEntity<Message> (message, HttpStatus.INTERNAL_SERVER_ERROR);

		
		return entity;
	}
	
}
