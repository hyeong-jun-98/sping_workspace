package com.academy.shopping.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.shopping.exception.ProductException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.product.ProductDAO;
import com.academy.shopping.model.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List selectAll() {

		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_id) {

		return null;
	}

	// 등록완성 = db에 넣기 + 파일 저장
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void regist(Product product, String savePath) throws UploadException, ProductException {

		String filename = fileManager.save(product, savePath); // 파일 저장
		product.setProduct_img(filename);  // 새롭게 생성된 파일명 저장.
		productDAO.insert(product); // db에 저장

	}

	@Override
	public void update(Product product) {
	}

	@Override
	public void delete(Product product) {
	}

}
