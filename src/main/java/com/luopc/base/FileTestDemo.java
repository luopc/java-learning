package com.luopc.base;

import java.io.File;

import org.junit.Test;

public class FileTestDemo {
	
	@Test
	public void test01() {
		String basePath = "H:\\视频资料\\Tomcat集群与Redis分布式";
		File file = new File(basePath);
		changeFileName(file);
	}
	
	private void changeFileName(File file) {
		if(file.exists()) {
			
			File[] files = file.listFiles();
			for (File fd : files) {
				if(fd.isDirectory()) {
					changeFileName(fd);
				}else {
//					System.out.println(fd.getName());
					String fdName = fd.getName();
					System.out.println(fd.getParent());
					if(fdName.startsWith("[www.zxit8.com 自学IT吧论坛]  ")) {
						String newFName = fdName.substring("[www.zxit8.com 自学IT吧论坛]  ".length(), fdName.length());
						fd.renameTo(new File(fd.getParent(),newFName));
					}
				}
			}
		}
	}

}
