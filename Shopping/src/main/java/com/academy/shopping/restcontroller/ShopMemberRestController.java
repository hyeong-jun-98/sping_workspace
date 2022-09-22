package com.academy.shopping.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity regist(Member member) {
		System.out.println(member.getCustomer_id());
		System.out.println(member.getCustomer_name());
		System.out.println(member.getCustomer_pass());
		System.out.println(member.getCustomer_email());

		memberService.insert(member);

		Message message = new Message(1, "가입성공");

		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}

	@GetMapping("/member/{customer_id}")
	public ResponseEntity<Message> getId(@PathVariable("customer_id") String customer_id) {
		
		memberService.selectCustomerId(customer_id);
		Message message = new Message(1, customer_id+" 사용가능");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> handleException(MemberException e) {

		Message message = new Message(0, e.getMessage());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}
}
