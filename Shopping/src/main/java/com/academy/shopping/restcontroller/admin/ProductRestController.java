package com.academy.shopping.restcontroller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.model.category.ProductService;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.util.FileManager;
import com.academy.shopping.model.util.Message;


@RestController
public class ProductRestController {
	
	
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/admin/product/delete")											// json과 DTO의 Mapping
	public ResponseEntity<Message> delete(HttpServletRequest request, @RequestBody Product product) {
		
		System.out.println("상품정보 id : " + product.getProduct_id());
		System.out.println("상품정보 이름 : " + product.getProduct_name());
		
		String dest = request.getServletContext().getRealPath("/resources/data/" + product.getProduct_img());
		
		productService.remove(product, dest);
		Message message = new Message(1, "상품 삭제 성공");
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}

}
