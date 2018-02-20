package com.luopc.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericeDemo01 {

	public static void main(String[] args) {
		List<Object> objs = new ArrayList<Object>(); 
		inspect(objs); //success
		
		List<String> strs = new ArrayList<String>();    
//	    inspect(strs); //编译错误
	}
	
	public static void inspect(List<Object> list) {    
	    for (Object obj : list) {        
	        System.out.println(obj);    
	    }    
	    list.add(1); //这个操作在当前方法的上下文是合法的。 
	}

}
