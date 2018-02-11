package com.luopc.base.jihe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ListTest01 {

	public static void main(String[] args) {
		final int N = 1000000;  
        Object obj = new Object();  
  
        /*没用调用ensureCapacity()方法初始化ArrayList对象*/  
        ArrayList list = new ArrayList();  
        long startTime = System.currentTimeMillis();  
        for (int i = 0; i <= N; i++) {  
            list.add(obj);  
        }  
        long endTime = System.currentTimeMillis();  
        System.out.println("没有调用ensureCapacity()方法所用时间：" + (endTime - startTime) + "ms");  
  
        /*调用ensureCapacity()方法初始化ArrayList对象*/  
        ArrayList list2  = new ArrayList();  
        startTime = System.currentTimeMillis();  
          
        // 预先设置list的大小  
        list2.ensureCapacity(N);  
        for (int i = 0; i <= N; i++) {  
        	list2.add(obj);  
        }  
        endTime = System.currentTimeMillis();  
        System.out.println("调用ensureCapacity()方法所用时间：" + (endTime - startTime)  + "ms");  

	}
	
	@Test
	public void test001() {
		User u = new User();
		List<User> uList = Collections.singletonList(u );
		System.out.println(uList);
		
		List<Integer> list = new ArrayList<Integer>();  
        list.add(1);  
        list.add(2);  
          
        for (Integer integer : list) {  
            System.out.println(integer);  
        }  
        /*找出最大值*/  
        int max = Collections.max(list);  
        System.out.println("最大的为:"+max);  
          
        /*用指定元素替换指定list中的元素*/  
        Collections.fill(list, 6);  
        System.out.println("替换后:");  
        for (Integer integer : list) {  
            System.out.println(integer);  
        }  
          
        /*找出某个list里某个元素的个数*/  
        int count = Collections.frequency(list, 6); //使用equals方法比较
        System.out.println("里面有6的个数:"+count);  
	}
	
	@Test
	public void test002() {
		List<Integer> list = new ArrayList<Integer>();  
        list.add(5);  
        list.add(2);  
        list.add(1);  
        list.add(9);  
        list.add(0);  
          
        System.out.println("原序列:");  
        for (Integer integer : list) {  
            System.out.print(integer+" ");  
        }  
        System.out.println();  
          
        /*根据步长进行循环*/  
        Collections.rotate(list, -1);  
        System.out.println("循环后:");  
        for (Integer integer : list) {  
            System.out.print(integer+" ");  
        }  
	}

}
