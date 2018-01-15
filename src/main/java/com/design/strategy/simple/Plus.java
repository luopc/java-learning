package com.design.strategy.simple;

public class Plus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}

	@Override
	public int calculate(int x, int y) {
		return x + y;
	}

}
