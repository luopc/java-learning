package com.spring.aop.http;

import com.spring.aop.http.bo.PrimaryHttpRequestBo;
import com.spring.aop.http.resource.ExampleResourceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpRequestTestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop-http-demo_1.xml");
        ExampleResourceService service = context.getBean("exampleResourceService",ExampleResourceService.class);
        String respnse =  service.getHeader("11", "David");
        System.out.println("header response: " + respnse);

        PrimaryHttpRequestBo requestBo = new PrimaryHttpRequestBo();
        requestBo.setId("22");
        requestBo.setName("Jason");
        String response = service.getBody(requestBo,"22","Jason",  22);
        System.out.println("Body response: " + response);
    }
}
