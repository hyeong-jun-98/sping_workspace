package com.academy.shopping.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.SubCategoryException;
import com.academy.shopping.model.domain.SubCategory;
import com.academy.shopping.model.domain.TopCategory;

@Service
public class SubCategoryServiceImpl  implements SubCategoryService{

	@Autowired
	private SubcategoryDAO subcategoryDAO;


	@Override
	public List selectAll() {
		
		return null;
	}

	@Override
	public List selectByTopCategoryId(int topcategory_id) {
		
		return subcategoryDAO.selectByTopCategoryId(topcategory_id);
	}

	@Override
	public SubCategory select(int subcategory_id) {
		
		return null;
	}
	

	@Override
	public void insert(SubCategory subcategory) throws SubCategoryException{
		
		 subcategoryDAO.insert(subcategory);
	
	}

	@Override
	public void update(SubCategory subcategory) {
	}

	@Override
	public void delete(SubCategory subcategory) {
	}


}
