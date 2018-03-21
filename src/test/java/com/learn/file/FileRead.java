package com.learn.file;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileRead {

	public static void main(String[] args) {
		InputStream in;
		try {
			in = new FileInputStream("E:\\桌面资料\\SQL\\BACK\\20170420-sd_data-bufen.dmp");
			int tempbyte;
			while ((tempbyte = in.read()) != -1) {
				
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
