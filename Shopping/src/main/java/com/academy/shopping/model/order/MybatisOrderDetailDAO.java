package com.academy.shopping.model.order;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.OrderDetailException;
import com.academy.shopping.model.domain.OrderDetail;
@Repository
public class MybatisOrderDetailDAO implements OrderDetailDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public OrderDetail selectByOrderSummaryId(int ordersummary_id) {
		
		return null;
	}

	@Override
	public void insert(OrderDetail orderdetail) throws OrderDetailException{
		int result = sqlSessionTemplate.insert("OrderDetail.insert", orderdetail);
		if(result == 0) {
			throw new OrderDetailException("주문 상세정보가 등록되지 않았습니다.");
		}
	}

	@Override
	public void update(OrderDetail orderdetail) {
	}

	@Override
	public void delete(OrderDetail orderdetail) {
	}

}
