package com.design.proxy.simple;

public class Proxy implements Sourceable {
	private Source source;

	public Proxy() {
		super();
		source = new Source();
	}

	@Override
	public void method() {
		before();
		source.method();
		after();
	}

	private void after() {
		System.out.println("after method");

	}

	private void before() {
		System.out.println("befor method");

	}

}
