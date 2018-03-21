package com.design.observer.simple;

import com.design.observer.simple.observer.Observer1;
import com.design.observer.simple.observer.Observer2;
import com.design.observer.simple.subject.MySubject;
import com.design.observer.simple.subject.Subject;
/**
 * 观察者设计模式
 * @author cheng
 *
 */
public class ObserverTest {

	public static void main(String[] args) {
		Subject sub = new MySubject();
		
		sub.add(new Observer1());
		sub.add(new Observer2());
		
		sub.operation();
	}

}
