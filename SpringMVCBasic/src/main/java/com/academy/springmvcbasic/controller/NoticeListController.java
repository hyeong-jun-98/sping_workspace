package com.academy.springmvcbasic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.academy.springmvcbasic.model.repository.NoticeDAO;

// 공지 게시판의 목록 요청을 처리하는 하위 컨트롤러 3,4 단계 수행
public class NoticeListController  implements Controller{
	
	private NoticeDAO noticeDAO;

	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ㅇㄴㅇㄴㅇ");
		List boardList = noticeDAO.selectAll();
		
		// 4단계로 저장
			ModelAndView mav = new ModelAndView();
			mav.addObject("boardList", boardList);
			mav.setViewName("board/list");

		return mav;
	}
}
