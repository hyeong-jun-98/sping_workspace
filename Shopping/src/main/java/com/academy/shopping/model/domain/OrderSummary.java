package com.academy.shopping.model.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderSummary {

	private int ordersummary_id;
	private int totalbuy;
	private int totalpay;
	private String buydate;
	private Member member;    // 누가 샀는지
	private Paymethod paymethod; // 어떤 결제 방법으로
	private List <OrderDetail> orderDetailList;
	
	
	
	
}
