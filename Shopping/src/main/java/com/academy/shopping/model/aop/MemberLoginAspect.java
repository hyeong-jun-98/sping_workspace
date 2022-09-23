package com.academy.shopping.model.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.category.TopCategoryService;

//횡단적 관심사에 대한 공통코드를 잓ㅇ해놓은 객체 (하나의 관점으로 둘 예정)
public class MemberLoginAspect {

	@Autowired
	private TopCategoryService topCategoryService;

	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable, MemberException {
		Object returnObj = null;
		System.out.println("회원 로그인 판단에 무조건 관여할 것이다.");

		// 세션을 끄집어내자
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = null;

		for (Object arg : args) { // 요청 객체 잡아내기
			if (arg instanceof HttpServletRequest) {
				request = (HttpServletRequest) arg;
			}
		}

		HttpSession session = null;
		String uri = request.getRequestURI();
		ModelAndView mav = null;

		if ( // 로그인 하지 않고도 접근 가능한 uri 명단
		uri.equals("/shop") 
		|| uri.equals("/shop/member/registform")
		|| uri.equals("/shop/member/loginform") 
		|| uri.equals("/shop/product") 
		|| uri.equals("/shop/product/view")) {
			
			// 원래 호출하려던 메서드 호출해주자
			returnObj = joinPoint.proceed();
			if (returnObj instanceof ModelAndView) {
				mav = (ModelAndView) returnObj;
			}
		} else { // 세션 체크
			session = request.getSession();
			if (session.getAttribute("member") == null) {
				throw new MemberException("회원 로그인이 필요한 서비스입니다.");
			} else {
				returnObj = joinPoint.proceed();
				if (returnObj instanceof ModelAndView) {
					mav = (ModelAndView) returnObj;
				}
			}
		}
		if(mav  != null) {		// 동생 컨트롤러의 메서드가 ModelAndView를 사용하는 경우만,,,,,,
			List topCategoryList = topCategoryService.selectAll();
			mav.addObject("topCategoryList", topCategoryList);
			returnObj = mav;
		}
		return returnObj;
	}

}
