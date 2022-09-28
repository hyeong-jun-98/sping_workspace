package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.domain.OrderDetail;
import com.academy.shopping.model.domain.OrderSummary;
@Repository
public interface OrderSummaryDAO {

	public List selectAll();
	public OrderSummary select (int ordersummary_id);
	public List selectByCustomerId(Member member);	//회원용
	public void insert(OrderSummary ordersummary);
	public void update(OrderSummary ordersummary);
	public void delete(OrderSummary ordersummary);
}
