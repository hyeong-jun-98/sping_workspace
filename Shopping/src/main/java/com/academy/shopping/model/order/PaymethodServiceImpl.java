package com.academy.shopping.model.order;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.model.domain.Paymethod;

@Service
public class PaymethodServiceImpl implements PaymethodService{

	@Autowired
	private PaymethodDAO paymethodDAO;
	
	@Override
	public List selectAll() {
		
		return paymethodDAO.selectAll();
	}

	@Override
	public Paymethod select(int paymethod_id) {
		
		return null;
	}

	@Override
	public void insert(Paymethod paymethod) {
		paymethodDAO.insert(paymethod);
	}

	@Override
	public void update(Paymethod paymethod) {
	}

	@Override
	public void delete(Paymethod paymethod) {
	}

}
