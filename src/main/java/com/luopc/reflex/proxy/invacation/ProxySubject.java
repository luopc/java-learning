package com.luopc.reflex.proxy.invacation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxySubject implements InvocationHandler {
	
	private Object taget;
	
	@SuppressWarnings("unchecked")
	public <T> T bind(Object taget) {
		this.taget =  taget;
		Object obj = Proxy.newProxyInstance(taget.getClass().getClassLoader(), taget.getClass().getInterfaces(), this);
		return (T) obj;
	}
	
	public void prepare() {
		System.out.println("[PraxySubject]-prepare");
	}
	
	public void clear() {
		System.out.println("[PraxySubject]-clear");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.prepare();
		Object ret = method.invoke(this.taget, args);
		this.clear();
		return ret;
	}

}
