package com.academy.shopping.model.category;

import java.util.List;

import com.academy.shopping.model.domain.TopCategory;

public interface SubCategoryService {

	public List selectAll();
	public TopCategory select(int topcategory_id);
	public void insert(TopCategory topcategory);
	public void update(TopCategory topcategory);
	public void delete(TopCategory topcategory);
	
}
