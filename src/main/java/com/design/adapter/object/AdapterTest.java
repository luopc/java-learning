package com.design.adapter.object;

import com.design.adapter.simple.Source;

public class AdapterTest {
	public static void main(String[] args) {
		Source sc = new Source();
		Targetable tt = new Wrapper(sc);
		tt.method1();
		tt.method2();
	}
}

