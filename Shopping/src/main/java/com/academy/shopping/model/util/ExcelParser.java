package com.academy.shopping.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.domain.SubCategory;

// 엑셀 파일을 분석하는 ㄷ객체
@Component
public class ExcelParser {

	public List getParseResult(File file) {
		
		// 엑셀파일에 접근을 위함
				List productList = new ArrayList();	//DTO를 담기위힘
				
				// 엑셀을 간접적으로 해석하여 insert DAO에게 시킬 것
				try {
					XSSFWorkbook workbook = new XSSFWorkbook(file);

					// 엑셀파일의 구성시트 저근
					XSSFSheet sheet = workbook.getSheetAt(0);

					// 하나의 row 접근
					int totalRow = sheet.getPhysicalNumberOfRows(); // 실제 사용자가 이려한 레코드 수
					System.out.println("totalRow : " + totalRow);

					for (int j = 0; j < totalRow; j++) {
						XSSFRow row = sheet.getRow(j);
						int totalCell = row.getPhysicalNumberOfCells(); // 하나의 row에 구성된 셀의 개수 (컬럼)
						Product product = new Product();

						for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
							XSSFCell cell = row.getCell(i);

							switch (i) {
								case 0: product.setProduct_name(cell.getStringCellValue()); break;
								case 1: product.setBrand(cell.getStringCellValue()); break;
								case 2: product.setPrice((int)cell.getNumericCellValue()); break;
								case 3: product.setDiscount((int)cell.getNumericCellValue()); break;
								case 4: product.setMemo(cell.getStringCellValue()); break;
								case 5: product.setDetail(cell.getStringCellValue()); break;
								case 6: product.setProduct_img(cell.getStringCellValue()); break;
								case 7: 
									SubCategory subCategory = new SubCategory();		// 자식 생성
									subCategory.setSubcategory_id((int) cell.getNumericCellValue());	// 자식에 pk를 넣음 
									product.setSubcategory(subCategory); break;			// product에 subcategory 다시 대입

							}

						}
						productList.add(product);
					}
					
					System.out.println("엑셀 분석 결과 : " + productList);

				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return productList;
	}
	
}
