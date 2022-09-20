package com.academy.shopping.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.model.category.SubCategoryService;
import com.academy.shopping.model.domain.SubCategory;

@RestController
public class SubCategoryRestController {

	@Autowired
	private SubCategoryService subCategoryService;

	// 관리자 - 해당 상위 카테고리에 소속된 하위 카테고리 목록 가져오기 요청 처리
	@GetMapping("/admin/subcategory/{topcategory_id}")
	public List getSubList(@PathVariable("topcategory_id") int topcategory_id) {

		System.out.println("넘어온 topcategory_id : " + topcategory_id);

		List subList = subCategoryService.selectByTopCategoryId(topcategory_id);
		System.out.println("넘어온 subcategory list :" + subList);

		return subList;

	}

	// 관리자 - 하위 카테고리 등록 요청
	@PostMapping("/admin/subcategory")
	public ResponseEntity<String> registSub(SubCategory subCategory) {
		subCategoryService.insert(subCategory);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=UTF-8");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("등록성공", HttpStatus.OK);

		return entity;
	}

}
