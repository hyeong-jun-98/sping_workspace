package com.academy.shopping.model.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

// 회원정보 중 비밀번호를 평문으로 넣지말자
// 암호화시켜넣을건데 16진수값의 해쉬값으로 변환하자.

@Component
public class HashManager {
	public static String getConvertedPassword(String password) {

		StringBuffer sb = null;

		// 위 문자열을 사람이 알아볼 수 없는 해쉬ㅏㅄ으로 변환해ㅗ보자
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8")); // 쪼개기 16진수로 만들기 위해

			// 쪼개진 데이터 크기만큼 반복문 돌리면서 하나씩 개병적으로 16진수 해쉬값으로 변환한 후 하나의 문자열로 모아놓자
			sb = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);

				if (hex.length() == 1) { // 한자리인경우 b -> 0b
					sb.append("0");
				}
				sb.append(hex); // 그냥 누적
			}

			System.out.println(sb);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
