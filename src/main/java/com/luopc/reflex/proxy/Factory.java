package com.luopc.reflex.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Factory {

	private Factory() {

	}

	public static <T> T getInstance(String calssName) {
		T t = null;
		try {
			t = (T) Class.forName(calssName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static <T> T getInstance(String calssName,Object obj) {
		T t = null;
		try {
			Constructor<?> cons = Class.forName(calssName).getConstructor(obj.getClass().getInterfaces()[0]);
			t = (T) cons.newInstance(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return t;
	}

}
