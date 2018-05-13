package com.luopc.serializable.xstream;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class XstreamTest {

	@Test
	public void test001() {
		XStream xs = new XStream();
		XmlObject xo = new XmlObject(10, 10.5, "110");
		String str = xs.toXML(xo);
		System.out.println(str);
	}

	@Test
	public void test002() {
		XStream xs = new XStream();
		XmlObject xo = new XmlObject(10, 10.5, "110");
		xs.alias("XmlObject", XmlObject.class);
		xs.aliasField("Count", XmlObject.class, "count");
		xs.aliasField("Price", XmlObject.class, "price");
		xs.aliasField("Phone", XmlObject.class, "phone");
		String str = xs.toXML(xo);
		System.out.println(str);
	}

	@Test
	public void test003() {
		int[] counts = { 10, 11, 12 };
		List<String> phones = new ArrayList<String>();
		phones.add("110");
		phones.add("119");
		phones.add("120");
		Map<String, Date> calendar = new HashMap<String, Date>();
		calendar.put("1", new Date());
		calendar.put("2", new Date());
		XStream xs = new XStream();
		XmlListObject xo = new XmlListObject(counts, phones, calendar);
		xs.alias("XmlListObject", XmlListObject.class);
		xs.aliasField("Count", XmlListObject.class, "counts");
		xs.aliasField("Phones", XmlListObject.class, "phones");
		xs.aliasField("Calendar", XmlListObject.class, "calendar");
		String str = xs.toXML(xo);
		System.out.println(str);
	}
	
	@Test
	public void test004() {
	    XStream xs = new XStream();
	    String xmlStr = "<com.luopc.serializable.xstream.XmlObject><count>10</count><price>10.5</price><phone>110</phone></com.luopc.serializable.xstream.XmlObject>";
	    XmlObject xo = (XmlObject)xs.fromXML(xmlStr);
	    System.out.println(xo);
	}
	
	@Test
	public void test005() {
		System.out.println(System.getProperty("java.library.path"));
	}

}
