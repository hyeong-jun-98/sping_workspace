package com.academy.shopping.model.util;

import lombok.AllArgsConstructor;
import lombok.Data;

// rest 요청에 대한 응정보를 보다 체계적으로 구성하기 위한 객체
// 그냥 String으로 응답하면 @ResponseBody의 json 변환 기능을 사용할 수 없다..
// 따라서 자바의 객체를 자동으로 json으로 변환해주게끔 아래와 같은 클래스를 정의한다.

@Data
@AllArgsConstructor		// 모든 멤버변수들을 담을 수 있는 생성자를 만들어라

public class Message {

	private int code;
	private String msg;
	
	
}
