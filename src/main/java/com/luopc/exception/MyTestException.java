package com.luopc.exception;

public class MyTestException extends Exception {

	private static final long serialVersionUID = 5778993333999022655L;
	
	public MyTestException() {
	}
	
	public MyTestException(String name){
		super(name);
	}

	public MyTestException(String name, Exception e) {
		super(name,e);
	}

}
