package com.spring.aop.http.resource;

import com.spring.aop.http.bo.PrimaryHttpRequestBo;
import com.spring.aop.http.util.VerifyBody;
import com.spring.aop.http.util.VerifyBodyPolicy;
import com.spring.aop.http.util.VerifyHeader;
import org.springframework.stereotype.Service;

@Service
public class ExampleResourceService {

    @VerifyHeader
    public String getHeader(String id, String name){
        System.out.println("getHeader method is called.");
        return "Call Header";
    }


    @VerifyBody(type = VerifyBodyPolicy.MUST_BE_CONSISTENT)
    public String getBody(PrimaryHttpRequestBo requestBo, String id, String name,  Integer age){
        System.out.println("getBody method is called.");
        return "Call Body";
    }
}
