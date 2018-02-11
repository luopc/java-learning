package com.design.single;

public class MySynchronizeDemo {

	public static void main(String[] args) {
		SingletonCreator s1, s2;
		s1 = SingletonCreator.getInstance();
		s2 = SingletonCreator.getInstance();
		System.out.println(s1 == s2);
	}

}

class SingletonCreator {

	private SingletonCreator() {
	}

	private static class HolderClass {
		private static SingletonCreator createSelf = new SingletonCreator();
	}

	public static SingletonCreator getInstance() {
		return HolderClass.createSelf;
	}

}