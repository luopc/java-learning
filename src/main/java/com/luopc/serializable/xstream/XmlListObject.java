package com.luopc.serializable.xstream;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class XmlListObject {
	private int[] counts;
	private List<String> phones;
	private Map<String, Date> calendar;

	public XmlListObject(int[] counts, List<String> phones, Map<String, Date> calendar)
    {
        this.counts = counts;
        this.phones = phones;
        this.calendar = calendar;
    }

	public String toString() {
		return "count = " + counts + ", phones = " + phones + ", calendar = " + calendar;
	}
}
