package com.design.proxy.simple;

public class ProxyDemo {

	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
	}

}
