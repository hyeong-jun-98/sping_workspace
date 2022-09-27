package com.academy.shopping.model.order;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.PaymethodException;
import com.academy.shopping.model.domain.Paymethod;
@Repository
public class MybatisPaymethodDAO implements PaymethodDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List selectAll() {
		List paymethodList =  sqlSessionTemplate.selectList("Paymethod.selectAll");	// typealias
		return paymethodList;
	}

	@Override
	public Paymethod select(int paymethod_id) {
		
		return null;
	}

	@Override
	public void insert(Paymethod paymethod) throws PaymethodException {
		int result =  sqlSessionTemplate.insert("Paymethod.insert", paymethod);
		if(result == 0) {
			throw new  PaymethodException("결제 실패"); 
		}
	}

	@Override
	public void update(Paymethod paymethod) {
	}

	@Override
	public void delete(Paymethod paymethod) {
	}

}
