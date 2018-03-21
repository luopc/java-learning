package com.luopc.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class MyOwnInputStream extends FilterInputStream {

	protected MyOwnInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = 0;
		if ((c = super.read()) != -1) {
			if (Character.isLowerCase(c)) {
				return Character.toUpperCase(c);
			} else if (Character.isUpperCase(c)) {
				return Character.toLowerCase(c);
			} else {
				return c;
			}
		}
		return super.read();
	}

}

public class MyOwnInputStreamDemo {

	public static void main(String[] args) throws IOException {
		//charTest.txt = ASAHSJKASJAHSjasasas
		InputStream is = new MyOwnInputStream(
				new BufferedInputStream(new FileInputStream("D:\\java-output\\charTest.txt")));
		int rd = 0;
		byte [] tmp = new byte[100];
		while ((rd = is.read(tmp)) != -1) {
			System.out.print(rd);
		}
		is.close();
	}

}
