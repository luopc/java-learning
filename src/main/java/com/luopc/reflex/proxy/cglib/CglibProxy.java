package com.luopc.reflex.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	
	@SuppressWarnings("unchecked")
	public <T> T bind(Class<T> cls) {
		Object rs = Enhancer.create(cls, this);
		return (T) rs;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		return methodProxy.invokeSuper(obj, args);
	}

}
