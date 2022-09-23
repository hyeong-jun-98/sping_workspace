package com.academy.shopping.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.Member;

@Controller
public class ShopMemberController {

	@Autowired
	private TopCategoryService topCategoryService;

	@GetMapping("/shop/member/registform")
	public ModelAndView getRegistForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/shop/member/join");

		List topcategoryList = topCategoryService.selectAll();
		mav.addObject("topCategoryList", topcategoryList);
		return mav;
	}

	@GetMapping("/shop/member/loginform")
	public ModelAndView getLoginForm(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/shop/member/login");
		List topcategoryList = topCategoryService.selectAll();
		mav.addObject("topCategoryList", topcategoryList);
		return mav;
	}
	
	@GetMapping("/shop/member/logout")
	public ModelAndView getLogout(HttpServletRequest request) {
		// 세션을 무효화시킴 , 이 시점부터는 세션에 담았던 모든 정보를 참조할 수 없다
		// 로그아웃을 하면 세션을 모두 닫아야한다.
		HttpSession session = request.getSession();
		session.invalidate();
		ModelAndView mav = new ModelAndView("redirect:/shop");
	
		return mav;
	}

}
