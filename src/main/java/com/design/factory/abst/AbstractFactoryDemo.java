package com.design.factory.abst;

public class AbstractFactoryDemo {
	public static void main(String[] args) {
		AbstractFactory factory = new SendMailFactory();
//		AbstractFactory factory = new SendSmsFactory();
		Sender send = factory.produce();
		send.send();
	}
}

interface AbstractFactory{
	public Sender produce();
}

class SendMailFactory implements AbstractFactory{

	@Override
	public Sender produce() {
		return new MailSender();
	}
	
}

class SendSmsFactory implements AbstractFactory{

	@Override
	public Sender produce() {
		return new SmsSender();
	}
	
}

interface Sender {
	public void send();
}

class MailSender implements Sender{

	@Override
	public void send() {
		System.out.println("Mail send~");
	}
	
}

class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("Sms send~");
	}
	
}