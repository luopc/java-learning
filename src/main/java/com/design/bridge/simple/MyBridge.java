package com.design.bridge.simple;

public class MyBridge extends Bridge {
	
	@Override
	public void method() {
		getSource().method();
	}

}
