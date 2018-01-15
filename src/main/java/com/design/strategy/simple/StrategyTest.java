package com.design.strategy.simple;
/**
 * strategy 策略模式
 * Template Method 模板方法模式
 * @author luopc
 *
 */
public class StrategyTest {

	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println(result);

		String exp2 = "12-8";
		AbstractCalculator cal2 = new Minus();
		int result2 = cal2.calculate(exp2, "\\-");
		System.out.println(result2);
	}
}
