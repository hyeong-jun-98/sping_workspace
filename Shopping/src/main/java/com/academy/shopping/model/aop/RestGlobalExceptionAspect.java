package com.academy.shopping.model.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.exception.MemberException;
import com.academy.shopping.exception.ProductException;
import com.academy.shopping.model.util.Message;

@ControllerAdvice  //rest Controller에서 발생되는 모든 예외를 여기서 잡자.
public class RestGlobalExceptionAspect {
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> handleException(MemberException e) {
			
		// 응답 메세지 생성
		Message message = new Message(0, e.getMessage());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		
		return entity;
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Message> handleException(ProductException e) {
			
		// 응답 메세지 생성
		Message message = new Message(0, e.getMessage());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		
		return entity;
	}

	
	
}
