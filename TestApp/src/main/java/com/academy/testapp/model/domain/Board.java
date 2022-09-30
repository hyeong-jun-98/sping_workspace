package com.academy.testapp.model.domain;

import lombok.Data;

@Data
public class Board {

	private int board_id;
	private int hit;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	
}
