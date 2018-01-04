package com.luopc.reflex.emp.util;

public class StringUtils {

	private StringUtils() {
	}

	public static String initcap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
