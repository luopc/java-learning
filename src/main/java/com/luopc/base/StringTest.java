package com.luopc.base;

import org.junit.Test;

public class StringTest {

	public static void main(String[] args) {
		StringBuffer bf = new StringBuffer("13785428001");
		bf.replace(3, 7, "****");
		System.out.println(bf);

		StringBuilder bd = new StringBuilder("13785428001");
		bd.replace(3, 7, "****");
		System.out.println(bf);
		
		String str = "13785428001";
		String nstr = str.replace(str.substring(3, 7), "****");
		System.out.println(nstr);
	}

	@Test
	public void testString001() {
		String s = new String();
		String s1 = new String("hello");
		char[] c = { 'h', 'e', 'l', 'l', 'o' };
		String s2 = new String(c);
		String s3 = new String(c, 1, 3);
	}
	
	@Test
	public void test002() {  
        
        String s = "hello world";  
        String s1 = new String("hello world");  
        String s2 = new String("hello world");  
        String s3 = new String("hello");  
        String s4 = "hello world";  
          
        System.out.println(s.equals(s1));;  
        System.out.println(s1.equals(s2));  
        System.out.println(s1.equals(s3));  
        System.out.println("------------------");  
        System.out.println(s == s1);  
        System.out.println(s1 == s2);  
        System.out.println(s == s3);  
        System.out.println(s == s4);  
    }  
	
	@Test
	public void test003() {  
        String s = "helloworld";  
        String[] s2 = s.split("abc");  
        for (int i = 0; i < s2.length; i++) {  
            System.out.println(s2[i] + " " + i);  
        }  
    } 
	
	@Test
	public void test004() {
		String str = "abc";
		char data[] = {'a','b','c'};
		String str2 = new String(data);
		String str3 = new String(data).intern();
		
		System.out.println(str == str2);
		System.out.println(str == str3);
		
	}

}
