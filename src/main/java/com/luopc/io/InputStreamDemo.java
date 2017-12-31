package com.luopc.io;

import java.io.File;
import java.io.IOException;

public class InputStreamDemo {

	public static void main(String[] args) {
		File soap = new File("D:\\java-out\\new.txt");
		if (!soap.exists())
			try {
				soap.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
