package com.academy.shopping.model.category;

import java.io.File;
import java.util.List;

import com.academy.shopping.model.domain.Product;

public interface ProductService {

	public List selectAll();

	public List selectBySubId(int subcategory_id);

	public List selectByTopId(int topcategory_id);

	public Product select(int product_id);

	public void update(Product product);

	public void delete(Product product);

	public void regist(Product product, String path); // DAO + file 서비스는 좀 더 포괄적인 개념
	public void registByExcel(File file, String ori, String dest); // DAO + file 서비스는 좀 더 포괄적인 개념
}
