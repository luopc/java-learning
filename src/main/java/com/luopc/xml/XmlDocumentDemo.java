package com.luopc.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XmlDocumentDemo {

	@Test
	public void helloTest() {
		String xmladd = "D:\\workspace\\oxygen\\java_projects\\java-learning\\src\\main\\java\\com\\luopc\\xml\\xml\\hello.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(xmladd));
			Element root = doc.getDocumentElement();
			System.out.println(root.getTagName());
			NodeList persons = root.getElementsByTagName("name");
			for (int i = 0; i < persons.getLength(); i++) {
				Node child = persons.item(i);
				if(child.getNodeType() == Node.ELEMENT_NODE && child instanceof Element) {
					System.out.println(child.getNodeName() + ":" + child.getFirstChild().getNodeValue());
				}
				
				
//				NamedNodeMap person_attrs = person.getAttributes();
//				System.out.println(person.getChildNodes().getLength() + "个子节点");
				
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test01() {
		Document doc = getXmlDocument("D:\\java-out\\soap-query.xml");
		Element root = doc.getDocumentElement();
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof Element) {
				Element childEle = (Element) child;
				if (childEle.getTagName().indexOf("Body") > -1) {
					String sID = finValueByTagName(childEle, "sId");
					System.out.println("提取的sid = " + sID);
				}else 
					if(childEle.getTagName().indexOf("Header") > -1) {
					String userName = finValueByTagName(childEle, "userName");
					String userPassWord = finValueByTagName(childEle, "userPassWord");
					System.out.println("提取的userName = " + userName);
					System.out.println("提取的userPassWord = " + userPassWord);
				}
			}
		}
		
	}
	
	private Document getXmlDocument(String xmlText) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlText);
			return doc;
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String finValueByTagName(Element root, String tagName) {
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);			
			if(child.getNodeType() == Node.ELEMENT_NODE && child instanceof Element) {
				Element childEle = (Element) child;				
				NodeList params = childEle.getElementsByTagName(tagName);
				if(params.getLength() > 0 && params.item(0).getFirstChild() != null) {
					return params.item(0).getFirstChild().getNodeValue();
				}
			}
		}
		return "";
	}

}
