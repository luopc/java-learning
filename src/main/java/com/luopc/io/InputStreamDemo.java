package com.luopc.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) {
		File soap = new File("D:\\java-out\\soap-fileList.xml");
		if(soap.exists()) {
			try {
				InputStream input = new FileInputStream(soap);
				
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				
				byte data[] = new byte[100];
				int temp = 0;
				while((temp = input.read(data)) != -1) {
					bos.write(data, 0, temp);
				}
				
				bos.close();
				input.close();
				System.out.println(new String(bos.toByteArray()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
	}

}
