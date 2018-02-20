package com.design.factory.reflex;

import java.util.Properties;

import org.junit.Test;

public class FactoryDemo {

	@Test
	public void test001() {
		String s = "apple";// 客户说需要一个苹果
		Fruit f = Factory.getInstance(s);// 把客户需求放入工厂开始生产
		f.produce();// 打印说明书
	}

	@Test
	public void test002() {
		Properties pro = new PropertiesOperate().getPro();// 创建Properties对象
		Fruit f = Factory.getInstance(pro.getProperty("apple"));// 使用getProperty(key)方法获得apple全名
		f.produce();
	}

}
