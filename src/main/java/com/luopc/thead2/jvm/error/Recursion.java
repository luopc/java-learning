package com.luopc.thead2.jvm.error;

public class Recursion {

	public int currentValue = 0;

	public void recursionself() {
		currentValue += 1;
		recursionself();
	}

}
