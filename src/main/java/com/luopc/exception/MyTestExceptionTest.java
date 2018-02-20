package com.luopc.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MyTestExceptionTest {

	public void display(int i) throws MyTestException {
		if (i == 0) {
			throw new MyTestException("该值不能为0.......");
		} else {
			System.out.println(i / 2);
		}
	}

	public void f() throws MyTestException {
		try {
			FileReader reader = new FileReader("G:\\myfile\\struts.txt");
			Scanner in = new Scanner(reader);
			System.out.println(in.next());
		} catch (FileNotFoundException e) {
			// e 保存异常信息
			throw new MyTestException("文件没有找到--01", e);
		}
	}

	public void g() throws MyTestException {
		try {
			f();
		} catch (MyTestException e) {
			// e 保存异常信息
			throw new MyTestException("文件没有找到--02", e);
		}
	}
	/**
	 * 在同一try...catch...finally块中 ，如果try中抛出异常，且有匹配的catch块，则先执行catch块，再执行finally块。如果没有catch块匹配，则先执行finally，然后去外面的调用者中寻找合适的catch块。
	 * @param args
	 */
	public static void main(String[] args) {
		MyTestExceptionTest test = new MyTestExceptionTest();
		try {
//			test.display(0);
//			System.out.println( 5 / 0);
			test.g();
			System.out.println("---------------------");
		} catch (MyTestException e) {
			e.printStackTrace();
		} finally {
			System.out.println("--------- I finallly --------- ");
		}
	}

}
