package com.academy.springdb.exception;

// 뉴스와 관련된 예외 정보를 처리할 나만의 예외객체
// 썬에서 이미 명칭이 정해지고 try와 catch 처리를 강제하는 예외를 강요된 예외라고 하고,
// 개발자가 원하는 예외를 재정의하고 강요되지 않은 예외를 RuntimeException이라고 한다.
public class NewsException extends RuntimeException {
	public NewsException(String msg) {
		super(msg);
	}

	public NewsException(String msg, Throwable e) {
		super(msg, e);
	}

	public NewsException(Throwable e) {
		super(e);
	}

}
