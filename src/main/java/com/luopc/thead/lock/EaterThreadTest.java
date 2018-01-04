package com.luopc.thead.lock;

public class EaterThreadTest {

	public static void main(String[] args) {
		
		Tool lock_01 = new Tool("lock_01");
		Tool lock_02 = new Tool("lock_02");

		new EaterThread("zhangsan", lock_01, lock_02).start();
		new EaterThread("lisi", lock_01, lock_02).start();
	}

}
