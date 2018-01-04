package com.design.factory.simple;
/**
 * 简单工厂模式
 * 由具体的类来负责对象的创建
 * 调用者只负责使用
 * @author cheng
 *
 */
public class SimpleFactoryDemo {
	
	public static void main(String[] args) {
		try {
			Car c1 = Driver.driverCar("bm");
			c1.drive();
			Car c2 = Driver.driverCar("bz");
			c2.drive();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


class Driver{
	public static Car driverCar(String s) throws Exception {
		if("bz".equals(s)) {
			return new Benz();
		}else if("bm".equals(s)) {
			return new Baoma();
		}
		throw new Exception("No this Car");
	}
}


/**
 * 定义一个接口 
 * @author cheng
 *
 */
interface Car {
	public void drive();
}


class Benz implements Car{
	@Override
	public void drive() {
		System.out.println("I drive Benz");
	}
	
}

class Baoma implements Car{
	@Override
	public void drive() {
		System.out.println("I drive Baoma");
	}
}