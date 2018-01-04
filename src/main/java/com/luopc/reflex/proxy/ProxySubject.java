package com.luopc.reflex.proxy;

public class ProxySubject implements ISubject {

	private ISubject subject;

	public ProxySubject(ISubject subject) {
		this.subject = subject;
	}

	public void prepare() {
		System.out.println("需要食材，收拾食材~");
	}

	@Override
	public void eat() {
		this.prepare();
		this.subject.eat();
		this.clear();
	}

	public void clear() {
		System.out.println("洗刷碗筷~");
	}

}
