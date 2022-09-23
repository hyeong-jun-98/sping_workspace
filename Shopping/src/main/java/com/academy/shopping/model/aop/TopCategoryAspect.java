package com.academy.shopping.model.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;

// 쇼핑몰에서 상위 카테고리는 어디서건 보여줄 정보이므로 어플리케이션의 횡단적 관심사항에 해당된다.
// 따라서 상위 카테고리 목록을 가져오는 코드를 별도의 객체로 정의하여, AOP의 Aspect로 정의해놓고, 필요할 때마다 이 코드를 관여시키자.

public class TopCategoryAspect {

	@Autowired
	private TopCategoryService topCategoryService;

	// 이 메서드는 쇼핑몰의 상위 카테고리를 필요로 하는 모든 메서드에서 활용할 예정
	public Object getCategoryList(ProceedingJoinPoint joinPoint) {

		System.out.println("컨트롤러가 동작할 때 나 관여하는중");

		// 원래 호출하려던 객체명 알아맞추기
		Object target = joinPoint.getTarget();
		System.out.println("호출하려던 객체는 " + target.getClass().getName());
		
		System.out.println("호출하려는 메서드"+joinPoint.getSignature()); 
		
		Object returnObj = null;
		try {
			returnObj = joinPoint.proceed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		 
		// 원래의 요청 대신 aspect가 컨트롤러의 메서드를 대신 호출하고 반환된 modelandview에 정보를 심어본다
		if(returnObj instanceof ModelAndView) {		// 자료형이 model and voew인지 구분
			ModelAndView 	mav =  (ModelAndView) returnObj;
			List topCategoryList =topCategoryService.selectAll();
			mav.addObject("topCategoryList", topCategoryList);
			returnObj = mav;
			
		}
	return returnObj; // DispatcherServlet에게 반환되며, 이때 형님(DispatcherServlet)은 viewResolver에게 jsp페이지를 얻기
					// 위한 해석을 ㅏㅌ긴다
}

}
