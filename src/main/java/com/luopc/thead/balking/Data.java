package com.luopc.thead.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {

	private final String fileName;

	private boolean changed;

	private String content;

	public Data(String fileName, String content) {
		super();
		this.fileName = fileName;
		this.content = content;
		this.changed = true;
	}

	public synchronized void change(String newContent) {
		content = newContent;
		changed = true;
	}

	public synchronized void save() throws IOException {
		if (!changed) {
			return;
		}
		doSave();
		changed = false;
	}

	private void doSave() throws IOException {
		System.out.println(Thread.currentThread().getName() + "calls doSave conten = " + content);

		Writer writer = new FileWriter(fileName);
		writer.write(content);
		writer.close();
	}

}
