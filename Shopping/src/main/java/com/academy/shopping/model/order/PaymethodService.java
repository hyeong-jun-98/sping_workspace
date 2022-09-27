package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academy.shopping.model.domain.Paymethod;
@Service
public interface PaymethodService {
	
	public List selectAll();
	public Paymethod select(int paymethod_id);
	public void insert(Paymethod paymethod);
	public void update(Paymethod paymethod);
	public void delete(Paymethod paymethod);


}
