package com.design.interpreter.simple;
/**
 * 解释器模式
 * @author luopc
 *
 */
public class InterpreterDemo {

	public static void main(String[] args) {
		int result = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
		System.out.println(result);
	}

}
