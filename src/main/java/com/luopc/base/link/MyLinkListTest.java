package com.luopc.base.link;

import org.junit.Test;

public class MyLinkListTest {

	@Test
	public void testAdd() {
		MyLinkList list = new MyLinkList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.print(list.length() + ":");
		list.printLink();
		list.delete(2);
		System.out.print(list.length()+ ":");
		list.printLink();
		
	}

	

}
