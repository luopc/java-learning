package com.luopc.xml.dom4j;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {

	public static void main(String[] args) {
//		String xmladd = "D:\\workspace\\oxygen\\java_projects\\java-learning\\src\\main\\java\\com\\luopc\\xml\\xml\\hello.xml";
		String xmladd = "D:\\java-out\\soap-query.xml";
		
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(xmladd));
			Element root = doc.getRootElement();
			Iterator<Element> it= root.elementIterator();
			while(it.hasNext()) {
				Element child = it.next();
				System.out.println(child.getName());
			}
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
