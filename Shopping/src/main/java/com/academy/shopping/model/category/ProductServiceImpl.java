package com.academy.shopping.model.category;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.shopping.exception.ProductException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.domain.SubCategory;
import com.academy.shopping.model.product.ProductDAO;
import com.academy.shopping.model.util.ExcelParser;
import com.academy.shopping.model.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService {

	// 하위 카테고리를 가져올 DAO
	@Autowired
	private SubcategoryDAO subcategoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;
	@Autowired
	private ExcelParser excelParser;

	@Override
	public List selectAll() {

		return productDAO.selectAll();
	}

	@Override
	public List selectByTopId(int topcategory_id) {
		List<SubCategory> subCategoryList = subcategoryDAO.selectByTopCategoryId(topcategory_id); // 서브 카테고리들의 목록 반환

		List productList = new ArrayList();
		for (int i = 0; i < subCategoryList.size(); i++) {
			SubCategory subCategory = subCategoryList.get(i);
			List<Product> list = productDAO.selectBySubId(subCategory.getSubcategory_id());
			for (Product product : list) {
				productList.add(product);
			}
		}

		return productList;
	}

	@Override
	public List selectBySubId(int subcategory_id) {

		return productDAO.selectBySubId(subcategory_id);
	}

	@Override
	public Product select(int product_id) {

		return productDAO.select(product_id);
	}

	// 등록완성 = db에 넣기 + 파일 저장
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void regist(Product product, String savePath) throws UploadException, ProductException {

		String filename = fileManager.save(product, savePath); // 파일 저장
		product.setProduct_img(filename); // 새롭게 생성된 파일명 저장.
		productDAO.insert(product); // db에 저장

	}

	@Override
	public void update(Product product) {
	}

	@Override
	public void delete(Product product) {
	}

	@Transactional(propagation = Propagation.REQUIRED)

	public void registByExcel(File file, String ori, String dest) {
		List<Product> productList = excelParser.getParseResult(file);

		FileOutputStream fos = null;
		FileInputStream fis = null;
		for (Product product : productList) {

			// 이미지를 서버에 저장하기 (스프링과 상관없이 개발자의 javaSE 능력으로 해결한다)
			try {
				fis = new FileInputStream(ori + "/" + product.getProduct_img());

				long time = System.currentTimeMillis();
				String ext = fileManager.getExt(product.getProduct_img());
				String filename = time + "." + ext; // 최종 파일명
				// 기존 DTO에 생성된 파일명을 다체하자
				product.setProduct_img(filename);
				
				fos = new FileOutputStream(dest + "/" + filename);

				int data = -1;
				while (true) {
					data = fis.read();
					if (data == -1)
						break;
					fos.write(data);
				}
				System.out.println("파일 복사 완료");
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} // 파일을 대상으로 한 출력 스트림
			catch (IOException e) {
				
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}

			productDAO.insert(product); // 레코드 한 건 넣기

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}
}
