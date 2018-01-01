package com.luopc.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析XML");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("结束解析XML");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("节点开始解析：" + qName);
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("节点结束解析：" + qName);
		super.endElement(uri, localName, qName);
	}

}
