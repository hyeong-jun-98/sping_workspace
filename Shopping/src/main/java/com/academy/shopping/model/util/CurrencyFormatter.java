package com.academy.shopping.model.util;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

// 정수를 대상으로 세자리 마다 쉼표러 끊어서 토와로 표현하자
@Component
public class CurrencyFormatter {

	public static String getCurrency(long num) {
		DecimalFormat df = new DecimalFormat(",###.###");

		return df.format(num);
	}

	public static void main(String[] args) {
	System.out.println(getCurrency(120000));	
	}
}
