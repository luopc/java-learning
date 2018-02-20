package com.design.factory.reflex;

public class Factory {

	public static Fruit getInstance(String className) {
		Fruit f = null;
		if (className.equals("apple")) {
			f = new Apple();
		} else {
			f = new Orange();
		}
		return f;
	}

	public static Fruit getReflexInstance(String className) {
		Fruit f = null;
		try {
			f = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
