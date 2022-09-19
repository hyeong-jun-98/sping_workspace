package com.academy.shopping.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.model.domain.TopCategory;
@Service
public class TopCategoryServiceImpl  implements TopCategoryService{
	
	@Autowired
	private TopCategoryDAO topCategoryDAO;

	@Override
	public List selectAll() {
		
		return topCategoryDAO.selectAll();
	}

	@Override
	public TopCategory select(int topcategory_id) {
		
		return null;
	}

	@Override
	public void insert(TopCategory topcategory) {
		topCategoryDAO.insert(topcategory);
		
	}

	@Override
	public void update(TopCategory topcategory) {
	}

	@Override
	public void delete(TopCategory topcategory) {
	}

}
