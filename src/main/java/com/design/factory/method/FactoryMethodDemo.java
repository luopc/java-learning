package com.design.factory.method;


/**
 * 工厂方法模式
 * @author cheng
 *
 */
public class FactoryMethodDemo {
	public static void main(String[] args) {
		Driver driver = new BenzDriver();
		Car c1 = driver.driverCar();
		c1.drive();
	}
}

/**
 * 定义一个司机接口
 * @author cheng
 *
 */
interface Driver{
	public Car driverCar();
}


class BenzDriver implements Driver{

	@Override
	public Car driverCar() {
		return new Benz();
	}
	
}

class BaomaDriver implements Driver{

	@Override
	public Car driverCar() {
		return new Baoma();
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