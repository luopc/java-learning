package com.design.observer.simple.subject;

import com.design.observer.simple.observer.Observer;
/**
 * 主体：被观察者(Observable)角色。 * 
 * @author cheng
 *
 */
public interface Subject {

	public void add(Observer observer);
	
	public void del(Observer observer);
	
	public void notifyObservers();
	
	public void operation();
}
