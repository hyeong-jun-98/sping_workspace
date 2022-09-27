package com.academy.shopping.model.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.Getter;
import lombok.Setter;

// 한줄씩 html 태그를 넣지말고 파일을 대상으로 스트림으로 읽어와 한줄씩 누적하여 문자열로 반환하는 객체
public class MailFormReader {

	FileReader reader;
	BufferedReader buffr;
	@Setter
	@Getter
	private String path; // 외부로부터 경로를 받은 상태

	public String getStringFromMailForm(String content) {
		StringBuffer sb = new StringBuffer();
		try {
			reader = new FileReader(path);
			buffr = new BufferedReader(reader);

			// 한줄 씩 읽어보자
			
			while (true) {
				String msg = buffr.readLine();
				if (msg == null)
					break;
				sb.append(msg); // 읽어들인 문자열을 버퍼에 추가.

			}
			System.out.println("읽은결과" + sb.toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}

}
