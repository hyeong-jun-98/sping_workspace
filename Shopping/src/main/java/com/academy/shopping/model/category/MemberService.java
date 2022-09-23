package com.academy.shopping.model.category;

import java.util.List;

import com.academy.shopping.model.domain.Member;


public interface MemberService {

	public List selectAll();
	public Member select(int member_id);
	public Member selectCustomerId(String customer_id);
	public Member selectByIdAndPass(Member member);
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member Member);
}
