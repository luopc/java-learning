package com.design.observer.simple.subject;

import com.design.observer.simple.subject.AbstractSubject;

public class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("update self!");
		notifyObservers();
	}

}
