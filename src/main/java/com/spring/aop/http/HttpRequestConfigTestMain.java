package com.spring.aop.http;

import com.spring.aop.http.bo.PrimaryHttpRequestBo;
import com.spring.aop.http.config.HttpRequestConfig;
import com.spring.aop.http.resource.ExampleResourceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HttpRequestConfigTestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (HttpRequestConfig.class);
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
