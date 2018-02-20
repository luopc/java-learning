package com.luopc.compiler;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

class B {
	static int value = 100;
	static {
		System.out.println("Class B is initialized."); // 输出
	}
}

class A extends B {
	static {
		System.out.println("Class A is initialized."); // 不会输出
	}
}

public class InitTest {
	public static void main(String[] args) {
		System.out.println(A.value); // 输出100
	}
	
	public void inspect(List<Object> list) {    
	    for (Object obj : list) {        
	        System.out.println(obj);    
	    }    
	    list.add(1); //这个操作在当前方法的上下文是合法的。 
	}
	public void test() {    
	    List<String> strs = new ArrayList<String>();    
	   // inspect(strs); //编译错误 
	}  
	
//	public Subject login() throws LoginException {    
//	    TextInputCallbackHandler callbackHandler = new TextInputCallbackHandler();    
//	    LoginContext lc = new LoginContext("SmsApp", callbackHandler);    
//	    lc.login();    
//	    return lc.getSubject();
//	} 
}

