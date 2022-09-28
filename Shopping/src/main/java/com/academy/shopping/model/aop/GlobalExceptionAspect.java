package com.academy.shopping.model.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.exception.EmailException;
import com.academy.shopping.exception.MemberException;
import com.academy.shopping.exception.OrderDetailException;
import com.academy.shopping.exception.OrderSummaryException;
import com.academy.shopping.exception.ProductException;
import com.academy.shopping.model.util.Message;

@ControllerAdvice  //모든 컨트롤러에서 나는 오류를 관여한다 -> 컨트롤러 밖에서 나는 에러를 잡을 수 잇다.
public class GlobalExceptionAspect {

	@ExceptionHandler(AdminException.class)
	public ModelAndView handleException(AdminException e) {
		
		ModelAndView mav = new ModelAndView("admin/error/result");
		mav.addObject("e", e);
		
		return mav;
	}
	
	@ExceptionHandler(MemberException.class)
	public ModelAndView handleException(MemberException e) {
		
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);
		
		return mav;
	}
	
	@ExceptionHandler(OrderSummaryException.class)
	public ModelAndView handleException(OrderSummaryException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);
		return mav;
	}
	@ExceptionHandler(OrderDetailException.class)
	public ModelAndView handleException(OrderDetailException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);
		return mav;
	}
	
	@ExceptionHandler(EmailException.class)
	public ModelAndView handleException(EmailException e) {
		ModelAndView mav = new ModelAndView("shop/error/result");
		mav.addObject("e", e);
		return mav;
	}
	

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Message> handleException(ProductException e) {
			
		// 응답 메세지 생성
		Message message = new Message(0, e.getMessage());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		
		return entity;
	}
	
	
	
}
