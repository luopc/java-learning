package com.design.builder.simple;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	private List<Sender> list = new ArrayList();

	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}
	
	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}

}

interface Sender {
	void send();
}

class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("sms send msg!");
	}

}

class MailSender implements Sender {
	public void send() {
		System.out.println("mail send msg!");
	}
}