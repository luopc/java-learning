package com.design.builder.media;

import com.design.builder.media.builder.Builder;
import com.design.builder.media.creatBuilder.GoodbyeBuilder;
import com.design.builder.media.creatBuilder.WelcomeBuilder;
import com.design.builder.media.director.Director;

public class Client {

	public static void main(String[] args) {
//		Builder builder =  new WelcomeBuilder();		
		Builder builder =  new GoodbyeBuilder();
		Director director = new Director(builder);
		director.construct("toAddress@to.com", "fromAddress@from.com");
		
	}

}
