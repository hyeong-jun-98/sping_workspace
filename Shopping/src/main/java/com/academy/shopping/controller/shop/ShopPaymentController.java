package com.academy.shopping.controller.shop;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.Cart;
import com.academy.shopping.model.domain.Member;

@Controller
public class ShopPaymentController {

	@Autowired
	private TopCategoryService topCategoryService;

	/* 장바구니 목록 요청 */
	@GetMapping("/shop/cart/list")
	public ModelAndView getCartList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/shop/payment/cart");

		/*
		 * 로그인 한 후 장바구니에 물건 담기ㅏ 성공했다는 것은 세션에 객체가 담겨져 있다는 의미다. 따라서 세션에 들어있는 product를
		 * 출력한다.
		 */

		HttpSession session = request.getSession();

		// 순서가 없는 map에서 객체들을 반복문으로 꺼내는 방법
		Enumeration<String> en = session.getAttributeNames(); // 키 값만 가져오는 메서드 (키만 들어있다)
		List cartList = new ArrayList();
		while (en.hasMoreElements()) { // 다음 요소가 있니? hasmoreElement
			String key = en.nextElement(); // 요소를 꺼내는 것. (key 값)
			session.getAttribute(key); // 키 값을 가져와서 꺼낸다.
			Object obj = (Object) session.getAttribute(key);
			if (obj instanceof Cart) {
				Cart cart = (Cart) obj;
				System.out.println("상품의 이름과 pk는" + cart.getProduct_name() + "," + cart.getProduct_id());
				cartList.add(cart);
			}

		}
		mav.addObject("cartList", cartList);
		return mav;
	}

	// 장바구니 새로고침
	@PostMapping("/shop/cart/update")
	public ModelAndView update(HttpServletRequest request) {

		String[] product_id = request.getParameterValues("product_id");
		String[] quantity = request.getParameterValues("quantity");

		HttpSession session = request.getSession();
		for (int i = 0; i < product_id.length; i++) {
			System.out.println("수정할 장바구니의 제품은 " + product_id[i] + "이고 그 수량은 각각 " + quantity[i]);

			// 세션에 들어잇는 cart 객체를 찾아내어 사용자가 수정한 수량을 반영하자.
			Cart cart = (Cart) session.getAttribute(product_id[i]);
			cart.setQuantity(Integer.parseInt(quantity[i])); // 수량변경
		}

		ModelAndView mav = new ModelAndView("redirect:/shop/cart/list");

		return mav;
	}

	@GetMapping("/shop/cart/delete")
	public ModelAndView deleteCart(HttpServletRequest request, int product_id) {
		HttpSession session = request.getSession();
		session.removeAttribute(product_id + ""); // key값을 이용하여 map으로부터 제거

		return new ModelAndView("redirect:/shop/cart/list");
	}

	// 결제 페이지 보여주기
	@GetMapping("/shop/checkout")
	public ModelAndView getCheckout(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/shop/payment/checkout");

		HttpSession session = request.getSession();

		// 회원정보

		// 장바구니 목록
		Enumeration<String> en = session.getAttributeNames(); // 순서없는 map의 key값을 추출하여
		Member member = null;
		List<Cart> cartList = new ArrayList();
		while (en.hasMoreElements()) { // key 값 만큼
			String key = en.nextElement(); // 요소추출
			Object obj = session.getAttribute(key); // 뭐가 반환되는지 알 수 없음
			if (obj instanceof Member) {
				member = (Member) obj;
			} else if (obj instanceof Cart) {
				cartList.add((Cart) obj);
			}
		}
		mav.addObject("member", member);
		mav.addObject("cartList", cartList);
		
		return mav;
	}
	
	@PostMapping("/shop/pay")
	public ModelAndView pay (HttpServletRequest request) {
		
		// 구매자 정보
		
		
		// 배송정보
		
		
		// 결제정보
		
		
		return null;
	}
	
	
	

}
