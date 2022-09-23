package com.academy.shopping.model.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.academy.shopping.model.domain.Member;

@Repository
public interface MemberDAO {

	
	public List selectAll();
	public Member selectCustomerId(String customer_id);
	public Member selectByIdAndPass(Member member);
	public Member select(int member_id);
	public void insert(Member member);
	public void update(Member member);
	public void delete(Member member);
}
