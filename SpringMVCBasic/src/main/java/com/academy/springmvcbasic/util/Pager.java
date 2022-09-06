package com.academy.springmvcbasic.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Pager {
	private int totalRecord;
	private int pageSize = 10;
	private int totalPage;
	private int blockSize = 10;
	private int currentPage = 1;
	private int firstPage;
	private int lastPage;
	private int curPos;	// 페이지 당 시작 인덱스 (list의  0, 10, 20)
	private int num;	// 페이지 당 시작 번호 26 16 6
	
	
	public void init(List list, HttpServletRequest request) {
		totalRecord = list.size();
		totalPage = (int) Math.ceil((float)totalRecord/pageSize);
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage - (currentPage -1) % blockSize;
		lastPage = firstPage + (blockSize-1);
		curPos = (currentPage-1) * pageSize;
		num = totalRecord - curPos;
	}
	
	
}
