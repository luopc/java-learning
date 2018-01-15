package com.design.visitor.simple;

public class VisitorDemo {

	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject();
		sub.accept(visitor);
	}

}
