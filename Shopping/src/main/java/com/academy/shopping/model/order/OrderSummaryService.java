package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academy.shopping.model.domain.OrderSummary;

@Service
public interface OrderSummaryService {

	public void order(OrderSummary orderSummary);	// 컨트롤러가 호출한다 주문요약 +주문 상세+ 배송정보
	
	public List selectAll(); // 관리자가 호출할
	public OrderSummary select (int ordersummary_id);
	public OrderSummary selectByCustomerId(int ordersummary_id);
	public void update(OrderSummary ordersummary);
	public void delete(OrderSummary ordersummary);
	
	
	
}
