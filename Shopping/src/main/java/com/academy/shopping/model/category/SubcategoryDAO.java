package com.academy.shopping.model.category;

import java.util.List;

import com.academy.shopping.model.domain.SubCategory;
import com.academy.shopping.model.domain.TopCategory;

public interface SubcategoryDAO {

	
	public List selectAll();
	public List selectByTopCategoryId(int topcategory_id);
	public SubCategory select(int subcategory_id);
	public void insert(SubCategory subcategory);
	public void update(SubCategory subcategory);
	public void delete(SubCategory subcategory);
}
