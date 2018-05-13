package com.luopc.thead2.jvm.error;
/**
 * https://www.cnblogs.com/200911/p/3965108.html
 * @author cheng
 *
 */
public class VMStackOOM {
	
	public static void main(String[] args) {
        Recursion recursion = new Recursion();
        try {
            recursion.recursionself();
        } catch (Throwable e) {
            System.out.println("current value :" + recursion.currentValue);
            throw e;
        }
    }

}
