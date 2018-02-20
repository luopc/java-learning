package com.luopc.annotation.mooc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DescriptionTest {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.luopc.annotation.mooc.Child");
			boolean isExist = c.isAnnotationPresent(Description.class);
			if (isExist) {
				Description d = (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}

			Method[] ms = c.getMethods();
			for (Method mt : ms) {
				boolean isMexist = mt.isAnnotationPresent(Description.class);
				if (isMexist) {
					Description mtd = (Description) mt.getAnnotation(Description.class);
					System.out.println(mtd.value());
				}
			}

			for (Method mt : ms) {
				Annotation[] as = mt.getAnnotations();
				for (Annotation at : as) {
					if (at instanceof Description) {
						Description d = (Description) at;
						System.out.println(d.value());
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
