package com.academy.shopping.model.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.ui.Model;

import com.academy.shopping.exception.AdminException;

// 관리자모드에서 로그인을 거치지않고 진행한 요청에 대해 거부처리
public class AdminLoginAspect {

	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable, AdminException {
		Object returnObj = null;	// 원래 호출하려던 메서드의 호출 후 반환되는 객체 (String , ModelAndView)
		
		System.out.println("관리자의 컨트롤러의 메서드 호출에 내가 관여한다. ");
		
		// 세션을 얻어와서 해당 세션에 admin 객체가 들어있는지 판단 및 처리
		Object [] args =  joinPoint.getArgs(); 	// 원래 호출하려던 메서드의 매개변수들
		HttpServletRequest request = null;
		
		for(	int i = 0;i<args.length;i++)	{
			if (args[i] instanceof HttpServletRequest) {
				request = (HttpServletRequest) args[i];
			}
		}
		HttpSession session=  null;
		String uri = request.getRequestURI();
		// 로그인이 필요한 서비스와 그렇지 않은 서비스로 조건을 크게 나눈다.
		
		if(uri.equals("/admin/loginform")) {
				returnObj = joinPoint.proceed();
		}else {
		if (request != null) {
			session = request.getSession();

			if (session.getAttribute("admin") == null) {
				System.out.println("인증 필요");
				throw new AdminException("관리자 로그인이 필요합니다.");
			} else {
				// 원래 호출하려했던 메서드를 대신 호출해주자
				returnObj = joinPoint.proceed();
			}

		}

	}

	

	return returnObj;
}

}
