package com.academy.shopping.model.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.ResponseEntity;

import com.academy.shopping.exception.MemberException;

public class RestMemberLoginAspect {
	String TAG = this.getClass().getName(); // 현재 클래스명이 담아짐

	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable, MemberException {
		Object returnObj = null;

		System.out.println(TAG + "Rest 방식 회원 로그인 판단에 관여함");
		System.out.println(TAG + "호출하려던 메서드" + joinPoint.getSignature().getName());

		HttpServletRequest request = null;
		HttpSession session = null;

		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(TAG + "매개변수" + arg);
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest) arg;
			}
		}

		// 제외될 명단을 작성하기 위한 uri 조사
		String uri = request.getRequestURI();
		ResponseEntity entity = null;
		if (
				uri.equals("/rest/member/login") || 
				uri.equals("/rest/member/check") || 
				uri.equals("/rest/member")  
				
				) {
			returnObj = joinPoint.proceed();
			if (returnObj instanceof ResponseEntity) {
				entity = (ResponseEntity) returnObj;
			}
		} else {
			// 회원 로그인 여부 판단
			session = request.getSession();
			if (session.getAttribute("member") == null) {
				throw new MemberException("회원 로그인이 필요한 서비스입니다. (rest)");
			} else {
				returnObj = joinPoint.proceed(); // 원래 호출하려면 메서드 호출
				// returnObj 검증
				if (returnObj instanceof ResponseEntity) {
					entity = (ResponseEntity) returnObj;
					System.out.println("엔티티 반환" + entity);
				}
			}
		}

		return returnObj;
	}

}
