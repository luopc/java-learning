package com.luopc.reflex.emp.util;

import java.lang.reflect.InvocationTargetException;

public class BeanOperation {

	private BeanOperation() {

	}

	// String vlue =
	// "emp.name:lisi|emp.job:clerk|emp.dept.name:财务部|emp.dept.company.name:腾讯";
	public static void setBeanValue(Object actionObject, String msg) throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 如果想要进行内容的设置，那么必须将字符串拆分
		String resul[] = msg.split("\\|");
		for (int i = 0; i < resul.length; i++) {

			// 将属性名称和内容进行拆分emp.name:lisi
			String[] temp = resul[i].split(":");//
			String attribute = temp[0];// emp.name
			String value = temp[1];// lisi
			String fields[] = attribute.split("\\.");// emp.name
			if (fields.length > 2) {
				Object childObject = actionObject;
				for (int j = 0; j < fields.length -1; j++) {
//					System.out.println(fields[j] + "，" + fields[fields.length-1] + "，" + value);
					childObject = ObjectUtils.getObject(childObject, fields[j]);
				}
				ObjectUtils.setObjectValue(childObject, fields[fields.length -1], value);
				
				
			} else {
				Object cuObject = ObjectUtils.getObject(actionObject, fields[0]);
				ObjectUtils.setObjectValue(cuObject, fields[1], value);
				// System.out.println(cuObject);
			}
		}

	}

}
