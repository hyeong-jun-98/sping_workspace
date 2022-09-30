package com.academy.bootspa.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import lombok.Data;

@Data
@Entity
public class Board {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int board_id;
	
	private int hit;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	
}
