package com.luopc.reflex.emp.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectUtils {

	private ObjectUtils() {
	}
	
	public static void setObjectValue(Object wrapObject, String attribute,String value) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName =  "set" +StringUtils.initcap(attribute);
		Field field = wrapObject.getClass().getDeclaredField(attribute);
		if (field == null) {
			field = wrapObject.getClass().getField(attribute);
		}
		if (field == null)
			return ;

		Method method = wrapObject.getClass().getMethod(methodName,field.getType());
		method.invoke(wrapObject, value);
	}

	public static Object getObject(Object wrapObject, String attribute) throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		String methodName = "get" + StringUtils.initcap(attribute);
		Field field = wrapObject.getClass().getDeclaredField(attribute);
		if (field == null) {
			field = wrapObject.getClass().getField(attribute);
		}
		if (field == null)
			return null;

		Method method = wrapObject.getClass().getMethod(methodName);
		Object obj = method.invoke(wrapObject);
		if(obj == null) {
			System.out.println(field.getType());
			obj = field.getType().newInstance();
		}		
		return obj;
	}

}
