package com.academy.shopping.model.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.exception.MemberException;

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
	
	
}
