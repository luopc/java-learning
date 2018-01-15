package com.design.iterator.simple;

public class IteratorDemo {

	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator it = collection.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
