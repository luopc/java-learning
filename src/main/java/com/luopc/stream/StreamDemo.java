package com.luopc.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("AC");
		list.add("bC");
		list.add("bC");
		list.add("vC");
		
		/**
		 * 新增消费形接口处理输出
		 */
//		list.forEach(System.out::println);
//		System.out.println("-----------------");
//		list.forEach((x) -> System.out.println(x));

		 Stream<String> st = list.stream();
//		 System.out.println(st.count());
		 
//		 System.out.println(st.filter((e) -> e.contains("AC")).count());//过滤器		 
		 
//		 List<String> rs = st.filter((e) -> e.contains("AC")).collect(Collectors.toList());//过滤器
		 
		 List<String> rs = st.skip(2).limit(2).collect(Collectors.toList());//数据截取
		 System.out.println(rs);

		 
	}
	
	
	@Test
	public void test01() {
		
	}

}
