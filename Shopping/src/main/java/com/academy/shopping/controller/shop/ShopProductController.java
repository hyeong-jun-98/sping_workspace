package com.academy.shopping.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.ProductService;
import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.Product;

@Controller
public class ShopProductController {
	@Autowired
	private TopCategoryService topCategoryService;
	@Autowired
	private ProductService productService;

	// 상품목록 요청
	@GetMapping("/shop/product")
	public ModelAndView getProductMain(@RequestParam(defaultValue = "0") int topcategory_id,
			@RequestParam(defaultValue = "0") int subcategory_id, HttpServletRequest request) {

		// 카테고리 가져오기
		List topCategoryList = topCategoryService.selectAll();

		System.out.println("subcategory_id " + subcategory_id);

		List productList = null;

		if (topcategory_id != 0) {
			productList = productService.selectByTopId(topcategory_id);
		} else {
			if (subcategory_id == 0) {
				productList = productService.selectAll();
			} else {
				productList = productService.selectBySubId(subcategory_id);
			}
		}
		// 하위 카테고리에 소속된 상품 가져오기 (만일 선택된 하위 카테고리가 없는 상태라면 모두 가져오기)

		ModelAndView mav = new ModelAndView("shop/list");
		mav.addObject("topCategoryList", topCategoryList);
		mav.addObject("productList", productList);
		return mav;
	}
	
	@GetMapping("/shop/product/view")
	public ModelAndView getDetail(int product_id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("shop/detail");
		List topCategoryList = topCategoryService.selectAll();
		Product product = productService.select(product_id);
		
		mav.addObject("topCategoryList",topCategoryList);
		mav.addObject("product",product);
		
		return mav;
	}
	
	
	
}
