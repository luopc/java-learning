package com.design.command.simple;

public class InvokerDemo {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		
		Command cmd = new MyCommand(receiver);
		
		
		Invoker invoker =  new Invoker(cmd);
		invoker.action();

	}

}
