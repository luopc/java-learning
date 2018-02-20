package com.design.factory.reflex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesOperate {

	private Properties pro = null;
	
	File file = null;// 创建一个File对象 地址为：D：/fruit.properties

	public PropertiesOperate() {
		this.pro = new Properties();
		String url = this.getClass().getResource("/").getPath();
		file = new File(url + File.separator + "fruit.properties");
		if (file.exists()) {// 文件如果存在
			try {
				pro.loadFromXML(new FileInputStream(file));// 加载配置文件
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {// 如果不存在
			this.save();
		}
	}

	public Properties getPro() {
		return this.pro;
	}

	public void save() {// 创建一个新的配置文件
		this.pro.setProperty("apple", "com.design.factory.reflex.Apple");// 添加文件内容
		this.pro.setProperty("orange", "com.design.factory.reflex.Orange");// 添加文件内容
		try {
			this.pro.storeToXML(new FileOutputStream(this.file), "Fruit");// 把文件保存到指定目录，节点为Fruit
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
