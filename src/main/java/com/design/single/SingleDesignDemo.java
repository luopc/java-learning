package com.design.single;
/**
 * 单例模式
 * 
 * @author cheng
 *
 */
public class SingleDesignDemo {

	public static void main(String[] args) {
		MySingleMethod me = MySingleMethod.initMethod();
		me.sysout();
	}

}

class MySingleMethod {
	
	private static MySingleMethod method = new MySingleMethod();

	private MySingleMethod() {
	}

	public static MySingleMethod initMethod() {
		return method;
	}

	public void sysout() {
		System.out.println("I am SingleMethod~");
	}
}