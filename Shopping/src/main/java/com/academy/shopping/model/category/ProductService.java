package com.academy.shopping.model.category;

import java.util.List;

import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.domain.TopCategory;

public interface ProductService {

	
	public List selectAll();
	public Product select(int product_id);
			
	public void update(Product product);
	public void delete(Product product);
	public void regist(Product product, String path); // DAO + file  서비스는 좀 더 포괄적인 개념
}
