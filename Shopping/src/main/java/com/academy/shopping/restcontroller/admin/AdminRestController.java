package com.academy.shopping.restcontroller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.model.admin.AdminService;
import com.academy.shopping.model.domain.Admin;
import com.academy.shopping.model.util.HashManager;

// restController는 자동으로 @responseBody가 붙여진다
@RestController
public class AdminRestController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private HashManager hashManager;

	@PostMapping("/admin")
	@ResponseBody // RestController 애서는 이 속성이 자동부여된다. 그리고 이 속성의 의미는 결과 뷰 페이지를 매핑하는 것이 아니라 순수 데이터를
					// 전송하는 효과를 낸다. 따라서 비동기 응답에 적절하다.
					// body에 있는 데이터로 응답한다.
	public ResponseEntity regist(Admin admin) {
		adminService.insert(admin);

		// ResponseEntity 응답 정보를 전담하는 객채 (필수는 아니지만 http 응답정보에 최적화되어 있어서 편하다.)
		return new ResponseEntity(HttpStatus.OK);
//		return new ResponseEntity(데이터, HttpStatus.OK);
	}

	// 로그인 요청을 처리
	@PostMapping("/admin/login")
	public ResponseEntity<String> login(HttpServletRequest request, Admin admin) {
		// db에 있는 패스워드를 비교하기 전에 먼저 클라이언트가 전송한 password를 hash값으로 변환한 후 비교한다.

		String hashValue = hashManager.getConvertedPassword(admin.getPass()); // 평문인 비밀번호를 hash로 변경
		admin.setPass(hashValue); // DTO의 패스워드 값을 해쉬값으로 교체 (setter)
		Admin obj = adminService.selectByIdAndPass(admin); // 해당 아이디와 패스워드가 일치하는 회원이 있을 때 DTO가 null이 아니다.

		System.out.println("로그인 결과 : " + obj);

		// 세션에 정보를 담아두자
		HttpSession session = request.getSession();
		session.setAttribute("admin", obj);

		ResponseEntity<String> entity = new ResponseEntity<String>("1", HttpStatus.OK);

		return entity;
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<String> handleException(AdminException e) {

		ResponseEntity<String> entity = new ResponseEntity<String>("0", HttpStatus.OK);

		return entity;
	}

}
