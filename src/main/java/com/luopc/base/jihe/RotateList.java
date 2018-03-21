package com.luopc.base.jihe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.standard.PrinterLocation;

public class RotateList {

	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		li.add("a");
		li.add("b");
		li.add("c");
		li.add("d");
		li.add("e");
		li.add("f");
		li.add("g");
		li.add("m");

		rotate2(li, 2);
		
	}
	
	private static void rotate2(List<?> list, int distance) {
        int size = list.size();
        if (size == 0)
            return;
        int mid =  -distance % size;
        if (mid < 0)
            mid += size;
        if (mid == 0)
            return;
        // 将AB变为BA，可以先对A求逆，再对B求逆，再对整体求逆，则可以得到BA
        // 先反向0到mid的元素
        print(list);
        System.out.println(list.subList(0, mid));
        Collections.reverse(list.subList(0, mid));
        print(list);
        // 再反向mid到size的元素
        Collections.reverse(list.subList(mid, size));
        print(list);
        // 最后反向整个表
        Collections.reverse(list);
        print(list);
    }
	
	private static void print(List<?> list) {
		for (Object ob : list) {
			System.out.print(ob + ",");
		}
		System.out.println("\n---------------------");
	}

}
