package com.luopc.thead.test01;

import org.junit.Test;

public class PrintThreadTest{

	@Test
	public void test01() {
		new PrintThread("Hello-").start();
		new PrintThread("Hi-").start();	
		
	}
	
	@Test
	public void test02() {
		new Thread(new PrintRunnable("Hello-")).start();
		new Thread(new PrintRunnable("Hi-")).start();	
		
	}
}
