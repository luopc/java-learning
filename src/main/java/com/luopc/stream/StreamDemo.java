package com.luopc.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("AC");
		list.add("bC");
		list.add("bC");
		list.add("vC");
		
		Stream<String> st = list.stream();
		System.out.println(st.filter((e)->e.contains("AC")).count());
	}

}
