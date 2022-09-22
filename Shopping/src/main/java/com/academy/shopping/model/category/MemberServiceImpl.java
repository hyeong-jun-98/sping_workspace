package com.academy.shopping.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.domain.Member;

@Service
public class MemberServiceImpl  implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	
	@Override
	public List selectAll() {
		
		return null;
	}
	

	@Override
	public Member selectCustomerId(String customer_id) throws MemberException{
		
		return memberDAO.selectCustomerId(customer_id);
	}

	@Override
	public Member select(int member_id) {
		
		return null;
	}

	@Override
	public void insert(Member member)  throws MemberException{
		
		memberDAO.insert(member);
	}

	@Override
	public void update(Member member) {
	}

	@Override
	public void delete(Member Member) {
	}


}
