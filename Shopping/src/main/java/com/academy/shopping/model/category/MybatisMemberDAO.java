package com.academy.shopping.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.exception.SubCategoryException;
import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.domain.SubCategory;

@Repository
public class MybatisMemberDAO implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {

		return null;
	}

	@Override
	public Member select(int member_id) {
		
		return null;
	}
	
	@Override
	public Member selectCustomerId(String customer_id) throws MemberException {
		Member result =  sqlSessionTemplate.selectOne("Member.selectCustomerId", customer_id);
		if(result != null ) {
			throw new MemberException("중복된 아이디가 존재합니다.");
		}
		
		
		return result;
	}
	
	@Override
	public Member selectByIdAndPass(Member member) throws MemberException {
		
		Member result = sqlSessionTemplate.selectOne("Member.selectByIdAndPass",member);
		 if(result == null) {
			 throw new MemberException("로그인 정보가 올바르지 않습니다.");
		 }
		
		return result;
	}

	@Override
	public void insert(Member member) throws MemberException {

		int result =  sqlSessionTemplate.insert("Member.insert",member);
		
		if (result == 0) {
			throw new MemberException("등록실패");
		}
	}

	@Override
	public void update(Member member) {
	}

	@Override
	public void delete(Member member) {
	}

	


}
