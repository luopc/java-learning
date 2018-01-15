package com.design.visitor.simple;

public interface Subject {
	
	public void accept(Visitor visitor);
	
	public String getSubject();

}
