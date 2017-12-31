package com.luopc.thead.single;

import org.junit.Test;

public class SingleThreadTest {

	@Test
	public void test01() {
		// Thread thread = new Thread();
		System.out.println("---------s-t-a-r-t----------");
		Gate gate = new Gate();
		new UserThread(gate, "zhangsan", "zjz").start();
		new UserThread(gate, "lisi", "lsl").start();
		new UserThread(gate, "wangwu", "wow").start();

	}

}
