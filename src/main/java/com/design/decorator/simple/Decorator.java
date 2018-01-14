package com.design.decorator.simple;

public class Decorator implements Sourceable {

	private Sourceable source;

	public Decorator(Sourceable source) {
		super();
		this.source = source;
	}

	@Override
	public void method() {
		System.out.println("befor decorator");
		source.method();
		System.out.println("after decorator");
	}

}
