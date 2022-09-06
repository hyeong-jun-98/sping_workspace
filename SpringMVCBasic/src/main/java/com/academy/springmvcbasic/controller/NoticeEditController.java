package com.academy.springmvcbasic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.academy.springmvcbasic.domain.Notice;
import com.academy.springmvcbasic.model.repository.NoticeDAO;

public class NoticeEditController implements Controller{
	// new 하게되면 NoticeEditController와 NoticeDAO간 결합도가 너무 강해진다
	// 결합도가 너무 강해질 때 만일 NoticeDAO의 클래스가 사라져버리면....DI를 이용하여 약화시킹 수 있다...
	
	private NoticeDAO noticeDAO;
	
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String notice_id = request.getParameter("notice_id");
		String title = request.getParameter("title");	
		String writer = request.getParameter("writer");	
		String content = request.getParameter("content");	
		
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(notice_id));
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		noticeDAO.update(notice);	// 일 시키기!
		
		ModelAndView mav = new  ModelAndView("redirect:/board/content?notice_id="+notice_id);
	
		return mav;
	}

}
