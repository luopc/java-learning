package com.luopc.reflex;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class Member {
	
	@Override
	public String toString() {
		return "Member []";
	}

	public Member() {
		System.out.println("Member");
	}
}

public class ClassLoaderDemo {

	public static void main(String[] args) {
		// Class<?> cls = Member.class;
		// System.out.println(cls.getClassLoader());
		// System.out.println(cls.getClassLoader().getParent());
		// System.out.println(cls.getClassLoader().getParent().getClass().getClassLoader().getClass().getClassLoader());
		// System.out.println(cls.getClassLoader().getParent().getClassLoader().getClass().getClassLoader().getClass().getClassLoader());
		try {
			Class<?> cls = new MyClassLoader().loadData("com.luopc.reflex.Member");
			System.out.println(cls.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class MyClassLoader extends ClassLoader {
	public Class<?> loadData(String calssName) throws Exception {
		byte classData[] = this.loadClassData();
		return super.defineClass(calssName, classData, 0, classData.length);
	}

	public byte[] loadClassData() throws Exception {
		InputStream is = new FileInputStream(new File("D:\\Member.class"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte data[] = new byte[20];
		int temp = 0;
		while ((temp = is.read(data)) != -1) {
			bos.write(data, 0, temp);
		}
		byte ret[] = bos.toByteArray();
		is.close();
		bos.close();
		return ret;

	}
}