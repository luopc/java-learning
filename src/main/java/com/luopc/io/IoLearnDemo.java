package com.luopc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.junit.Test;

public class IoLearnDemo {

	@Test
	public void test01() {
//		String saop = getXmlString("D:\\java-output\\soap-query.xml");
		try (OutputStream os = new FileOutputStream(new File("D:\\java-output\\test.txt"))){
			for (int i = 0; i < 10; i++) {
				os.write("www.shunde.gov \r\n".getBytes());
			}
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getXmlString() {
		String path = "D:\\java-output\\soap-query.xml";
		File file = new File(path);
		try (InputStream is = new FileInputStream(file)){
			byte data[] = new byte[1024];
			int len = is.read(data);
			System.out.println("读取内容[" + new String(data, 0, len) + "]");
			is.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		return "";
	}
	
	@Test
	public void writerTest() {
		try {
			Writer out = new FileWriter("D:\\java-output\\writer.txt");
			out.write("世界和平");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
