package com.nio.test.buffer;

import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class BufferTest {

	public static void main(String[] args) {
		char[] myArray = new char[100];
		CharBuffer charbuffer = CharBuffer.wrap(myArray);

		IntBuffer buff = IntBuffer.allocate(10);
		int[] array = new int[] { 3, 5, 1 };

		buff = buff.wrap(array);

		buff.put(0, 7);
		System.out.println("缓冲区如下：");
		for (int i = 0; i < buff.limit(); i++) {
			System.out.print(buff.get() + "\t");
		}

		System.out.println("\n\r数组数据如下：");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}

		// buff.flip();//进行反转
		// buff.clear();//
		
		System.out.println("\n\r缓冲区：" + buff);
		
		IntBuffer buff2 = buff.duplicate();//复制一个新的缓冲区
		System.out.println("\n\r复制后的缓冲区：" + buff2);

	}

}
