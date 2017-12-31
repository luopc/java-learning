package com.luopc.algorithm;

import org.junit.Test;

public class Day01Test {

	public int[] getArray(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * (len * 10));
		}
		return arr;
	}

	@Test
	public void sort01() {
		int[] arr = { 1, 2, 3, 1, 5, 1, 2, 6, 5, 7 };
		int[] mark = new int[10];

		int[] rs = new int[arr.length];
		// for (int s = 0 ;s < mark.length;s++) {
		// mark
		// }
		// 将数据放入桶里
		for (int i = 0; i < mark.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == arr[j]) {
					mark[i]++;
				}
			}
		}

		// 将桶里的数取出来
		int mk = 0;
		for (int i = 0; i < mark.length; i++) {
			System.out.println(i + "出现" + mark[i] + "次");
			if (mark[i] > 0) {
				for (int j = 0; j < mark[i]; j++) {
					rs[mk] = i;
					mk++;
				}
			}
		}

		// 打印数组
		print(rs);
	}

	@Test
	public void sort02() {
		// 冒泡排序
		int[] arr = { 66, 72, 25, 55, 31, 48, 61, 25, 51, 68 };// getArray(10);
		int[] arr1 = { 72, 66, 55, 31, 48, 61, 25, 51, 68, 25 };
		int[] arr2 = { 72, 66, 55, 48, 61, 31, 51, 68, 25, 25 };
		print(arr);
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			print(arr);

		}
	}

	@Test
	public void sort03() {
		// 快速排序
		int[] arr = { 66, 72, 27, 55, 31, 48, 61, 25, 51, 68 };
		// int[] arr2 = {25,51,25,55,31,48,61,66,72,68};
		// int[] arr3 = {25,51,25,55,31,48,61,66,72,68};
		// int[] arr4 = {};
		print(arr);
		sortFun(arr, 0, arr.length - 1);
	}

	@Test
	public void sort04() {
		// 快速排序
		int[] arr = { 66, 72, 27, 55, 31, 48, 61, 25, 51, 68 };
		// int[] arr2 = {25,51,25,55,31,48,61,66,72,68};
		// int[] arr3 = {25,51,25,55,31,48,61,66,72,68};
		// int[] arr4 = {};
		print(arr);
		quicksort(arr, 0, arr.length - 1);
	}

	// 快速排序
	public static void sortFun(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int i = start;
		int j = end;
//		System.out.println("当前i=" + i + ",当前j=" + j + ":");
		int key = array[i];
		boolean flag = true;
		while (i != j) {
			if (flag) {
				if (key > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					flag = false;
					print(array);
				} else {
					j--;
				}

			} else {
				if (key < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					flag = true;
					print(array);
				} else {
					i++;
				}
			}
		}

		sortFun(array, start, j - 1);
		sortFun(array, i + 1, end);
	}

	public void quicksort(int[] sortArray, int low,int high){  
        if(low<high){  
            int middle = getMiddle(sortArray, low, high); 
            print(sortArray);  
            quicksort(sortArray, low, middle-1);  
            quicksort(sortArray, middle+1, high);  
        }  
    }  
	/* 第二种写法： */
	private int getMiddle(int[] sortArray, int low, int high) {
		int key = sortArray[low];
		while (low < high) {
			while (low < high && sortArray[high] >= key) {
				high--;
			}
			sortArray[low] = sortArray[high];
			while (low < high && sortArray[low] <= key) {
				low++;
			}
			sortArray[high] = sortArray[low];
		}
		sortArray[low] = key;
		return low;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				System.out.print(arr[i]);
			else
				System.out.print("," + arr[i]);
		}
		System.out.println("\n-----------------------------");
	}

}
