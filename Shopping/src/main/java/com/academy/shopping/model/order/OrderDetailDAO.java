package com.academy.shopping.model.order;

import org.springframework.stereotype.Repository;

import com.academy.shopping.model.domain.OrderDetail;
@Repository
public interface OrderDetailDAO {

	public OrderDetail selectByOrderSummaryId(int ordersummary_id);
	public void insert(OrderDetail orderdetail);
	public void update(OrderDetail orderdetail);
	public void delete(OrderDetail orderdetail);
}
