package com.luopc.algorithm;

public class ArraySortUtil {
	
	public static void sortFun(int[] array ,int start,int end) {
		if(start >= end) {
			return ;
		}
		
		int i = start;
		int j = end;
		
		int key = array[i];
		boolean flag = true;
				
		while(i != j) {
			if(flag) {
				if(key > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					flag = false;
				}else {
					j --;
				}
				
				if(key < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;					
					flag = true;
				}else {
					i++;
				}
			}
		}
		sortFun(array, start, end-1);
		sortFun(array, start +1, end);
		
		
	}

}
