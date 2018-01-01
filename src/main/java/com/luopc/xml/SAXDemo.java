package com.luopc.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXDemo {

	public static void main(String[] args) {
		
//		String xmladd = "D:\\workspace\\oxygen\\java_projects\\java-learning\\src\\main\\java\\com\\luopc\\xml\\xml\\hello.xml";
		String xmladd = "D:\\java-out\\soap-query.xml";
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new File(xmladd), new SAXParserHandler());
			
			
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};

	}

}
