package com.design.builder.media.creatBuilder;

import com.design.builder.media.builder.Builder;
import com.design.builder.media.product.WelcomeMessage;

public class WelcomeBuilder extends Builder {
	
	public WelcomeBuilder() {
		msg = new WelcomeMessage();
	}

	@Override
	public void buildSubject() {
		msg.setSubject("欢迎标题~");

	}

	@Override
	public void buildBody() {
		msg.setBody("欢迎内容~");

	}

}
