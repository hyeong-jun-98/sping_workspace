package com.academy.springdb.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Gallery {
	private String title;
	private String writer;
	private MultipartFile photo;
	
}
