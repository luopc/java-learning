package com.design.decorator.simple;
/**
 * 装饰模式
 * @author cheng
 *
 */
public class DecoratorDemo {

	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}

}
