package com.academy.bootspa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.bootspa.model.board.BoardService;
import com.academy.bootspa.model.domain.Board;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/board/main")
	public ModelAndView getMain() {
		System.out.println("메인 요청을 받았습니다!");
	
		return new ModelAndView("main");
	}
	
	
	// 등록요청처리
	
	@PostMapping("/board/regist")
	public ModelAndView regist(Board board) {
		System.out.println("동기 방식의 등록 요청 받음" + board);
		
		return null;
	}
	
	
	
	
	
}
