package com.luopc.reflex.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MessageProxy implements MethodInterceptor {

	private Object target;

	public MessageProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methods) throws Throwable {

		this.prepare();
		Object ret = method.invoke(this.target, args);
		this.clear();

		return ret;
	}

	public void prepare() {
		System.out.println("[MessageProxy]-prepare");
	}

	public void clear() {
		System.out.println("[MessageProxy]-clear");
	}

}
