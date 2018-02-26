package com.nio.test.buffer;

import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class CharBufferDemo {

    public static void main(String[] args) {
        CharBuffer cbuffer = CharBuffer.allocate(1024);

        char[] myArray = new char[] { 'a', 'b', 'c', 'd' };
        CharBuffer cbuffer2 = CharBuffer.wrap(myArray);
        cbuffer2.put(0, 'f');
        // 遍历缓冲区数据
        for (int i = 0; i < cbuffer2.limit(); i++) {
            System.out.print(cbuffer2.get() + "\n");
        }
        // 遍历数组数据
        for (int i = 0; i < myArray.length; i++) {
            System.out.printf("宿主元素[%d]的值=%s\r\n", i, myArray[i]);
        }

    }

}
