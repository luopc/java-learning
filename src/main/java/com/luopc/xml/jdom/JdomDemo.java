package com.luopc.xml.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JdomDemo {

	public static void main(String[] args) {
//		String xmladd = "D:\\workspace\\oxygen\\java_projects\\java-learning\\src\\main\\java\\com\\luopc\\xml\\xml\\hello.xml";
		String xmladd = "D:\\java-out\\soap-query.xml";
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document doc= saxBuilder.build(new File(xmladd));
			Element root= doc.getRootElement();
			List<Element> childList = root.getChildren();
			for (int i = 0; i < childList.size(); i++) {
				Element child = childList.get(i);
				System.out.println(child.getName());
			}
			
			
			
			
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}

	}

}
