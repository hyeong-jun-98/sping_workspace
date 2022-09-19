package com.academy.shopping.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.SubCategoryException;
import com.academy.shopping.model.domain.SubCategory;

@Repository
public class MybatisSubCategoryDAO implements SubcategoryDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List selectAll() {
		
		return sqlSessionTemplate.selectList("SubCategory.selectAll");
	}
	
	@Override
	public List selectByTopCategoryId(int topcategory_id) {
		
		return sqlSessionTemplate.selectList("SubCategory.selectByTopCategoryId", topcategory_id);
	}


	@Override
	public SubCategory select(int subcategory_id) {
		
		return null;
	}

	@Override
	public void insert(SubCategory subcategory) throws SubCategoryException {
		
		int result = sqlSessionTemplate.insert("SubCategory.insert", subcategory);
		if(result ==0) {
			throw new SubCategoryException("tlfvo");
		}
	}

	@Override
	public void update(SubCategory subcategory) {
	}

	@Override
	public void delete(SubCategory subcategory) {
	}

	
}
