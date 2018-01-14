package com.design.decorator.simple;

public class DecoratorDemo {

	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}

}
