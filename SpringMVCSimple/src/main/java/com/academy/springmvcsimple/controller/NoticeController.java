package com.academy.springmvcsimple.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springmvcsimple.domain.Notice;
import com.academy.springmvcsimple.model.notice.NoticeDAO;

// 이전과는 달리 하나의 게시판에 사용되는 컨트롤러를 매 기능마다 1:1 대응하게 클래스를 만들지말고
// 게시판 하나 당 하나의 컨트롤러를 만들자.
// 스프링의 버전이 올라갈수록 컨트롤러 클래스는 자유도가 높아졌기 때문에 특정 객체를 상속 받거나, 구현해야 할 의무가 사라졌다.

 								// 이 어노테이션을 선언하는 순간부터 스프링 MVC의 각종 기능을 사용할 수 있다.
@Controller				//특히 scan의 대상이 될 수 있다. 따라서 xml에 컨트롤러를 명시하지 않아도 인스턴스가 올라갈 수 ㅇ있다.
public class NoticeController {
	@Autowired	// 자동 엮기
	private NoticeDAO noticeDAO;
	
	// 목록 요청 메서드 : 어떠한 요청에 대해 이 메서드가 작동할 지 매핑을 표현한다
	@RequestMapping(value="/board/list", method = RequestMethod.GET)  // 글을 가져가는 거니까 GET 방식
	public String selectAll(Model model) {
		System.out.println("noticeDAO 주소값 : " + noticeDAO);
		List boardList = noticeDAO.selectAll();//3 단계
		
		model.addAttribute("boardList",boardList);
		
		return "board/list";
	}

	// 글 내용보기 요청 메서드
	@RequestMapping (value="/board/content" , method=RequestMethod.GET)
	public ModelAndView select(int notice_id) {
		System.out.println("notice_id : " + notice_id);
		
		// 3단계 일 시킨다.
		Notice notice = noticeDAO.select(notice_id);
		
		// 4단계 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice", notice);
		mav.setViewName("board/content");
		
		return mav;
	}
	
	
	// 삭제 요청 메서드
	@RequestMapping (value="/board/delete", method=RequestMethod.GET)
	public String delete(int notice_id) {
		
		noticeDAO.delete(notice_id);
		
		return "redirect:/board/list";
	}
	
	// 글 쓰기 요청 요청 메서드
	@RequestMapping (value="/board/regist", method = RequestMethod.POST)
	public String insert(Notice notice) {
		
		noticeDAO.insert(notice);

		return "redirect:/board/list";
	}
	
	// 수정 요청 메서드
	@RequestMapping (value="/board/edit" , method = RequestMethod.POST)
	public ModelAndView update(Notice notice) {
		
		noticeDAO.update(notice);
		
		return new ModelAndView("redirect:/board/content?notice_id=" + notice.getNotice_id());	
				
	
	}

}
