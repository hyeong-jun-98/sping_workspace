package com.academy.shopping.model.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.domain.Product;

@Component
public class FileManager {

	
	
	// 파일과 관련된 유용한 기능을 구현한 객체
	public String save(Product product, String savePath) throws UploadException {

		MultipartFile multi = product.getPhoto();

		// 파일 저장

		String ext = getExt(multi.getOriginalFilename());
		long time = System.currentTimeMillis();

		try {
			multi.transferTo(new File(savePath + "/" + time + "." + ext));

		} catch (IllegalStateException e) {

			e.printStackTrace();
			throw new UploadException("업로드 실패");
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println(multi.getOriginalFilename());

		
		return time + "." + ext;
	}

	// 확장자를 구한다
	public static String getExt(String path) {
		int index = path.lastIndexOf("."); // 가장 마지막 점의 인덱스 구하기
		String ext = path.substring(index + 1, path.length());
		return ext;
	}

	public static void main(String[] args) {
		String ext = getExt("dfdfdfdfdfdfdfd.dfdfd.fdfdfd.png");
		long time = System.currentTimeMillis();

		System.out.println(time + "." + ext);
	}
	
	// 엑셀 파일 업로드
	public File saveExcel(String path, MultipartFile excel) {
		
		File file =null;
		// 서버에 올라온 엑셀을 읽어보자
		try {

			excel.transferTo(file = new File(path+"/" + excel.getOriginalFilename()));
			System.out.println(file.getAbsolutePath());
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
		
	}
	
	
	
	
}
