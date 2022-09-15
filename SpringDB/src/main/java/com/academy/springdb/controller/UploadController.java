package com.academy.springdb.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.academy.springdb.model.domain.Gallery;

@Controller
public class UploadController {

	// 클라이언트가 전송한 이미지 파일을 업로드 처리...
	@PostMapping("/upload")
	public ModelAndView save(HttpServletRequest request, Gallery gallery) {
		System.out.println("업로드 요청 받기 성공");
		System.out.println(gallery.getTitle());
		System.out.println(gallery.getWriter());
		System.out.println(gallery.getPhoto());

		// 업로드된 파일에 대한 분석
		MultipartFile multi = gallery.getPhoto();
		System.out.println("파일 유형 : " + multi.getContentType());
		System.out.println("파일 이름 : " + multi.getOriginalFilename());
		System.out.println("html 파라미어 이름 : " + multi.getName());
		System.out.println("파일 크기 : " + multi.getSize() + "byte");

		// 아직 물리적 파일로 존재시킨 적이 없으므로, 원하는 서버의 디렉토리에 파일을 저장해본다.
		String path = request.getServletContext().getRealPath("/resources/data"); // jsp에서 application
																					
		String filepath = path + "/" + multi.getOriginalFilename();  	// 내장객체..getRealPath();
		try {
			multi.transferTo(new File(filepath));
			System.out.println(filepath);
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return null;
	}

}
