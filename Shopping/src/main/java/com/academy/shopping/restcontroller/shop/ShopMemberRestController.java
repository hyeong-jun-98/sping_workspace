package com.academy.shopping.restcontroller.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.category.MemberService;
import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.util.Message;

@RestController
public class ShopMemberRestController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/member")
	public ResponseEntity regist(HttpServletRequest request, Member member) {
		System.out.println(member.getCustomer_id());
		System.out.println(member.getCustomer_name());
		System.out.println(member.getCustomer_pass());
		System.out.println(member.getCustomer_email());

		memberService.insert(member);

		Message message = new Message(1, "가입성공");

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	@GetMapping("/member/check")
	public ResponseEntity<Message> getId(HttpServletRequest request, @RequestParam("customer_id") String customer_id) {
		
		memberService.selectCustomerId(customer_id);
		Message message = new Message(1, customer_id+" 사용가능");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	
	
	// 로그인 요청 처리
	@PostMapping("/member/login")
	public ResponseEntity<Message> login(HttpServletRequest request, Member member) {
		Member result =  memberService.selectByIdAndPass(member);
		
		
		// 로그인에 성공하면 회원정보를 유지할 수 있도록 세션에 Member DTO를 담아주자.
		HttpSession session =  request.getSession();
		session.setAttribute("member", result);
		Message message  = new Message(1, "로그인 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	

}
