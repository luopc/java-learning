package com.design.factory.reflex;

public interface Fruit {
	public void produce();

}

class Apple implements Fruit {// 产品一：苹果
	public Apple() {
		System.out.println("苹果生产了");
	}

	public void produce() {
		System.out.println("这是一个苹果");// 苹果的说明书
	}
}

class Orange implements Fruit {// 产品二：橘子
	public Orange() {
		System.out.println("苹果生产了");
	}

	public void produce() {
		System.out.println("这是一个橘子");// 橘子的说明书
	}
}