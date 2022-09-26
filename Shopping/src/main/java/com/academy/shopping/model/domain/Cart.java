package com.academy.shopping.model.domain;

import lombok.Data;

@Data
public class Cart extends Product {

	// 원본을 손상시키지 않기위해 나중에 set으로 1을 추가한다. 
	// 여기서 1을 줘도 된다.
	private int quantity;

}
