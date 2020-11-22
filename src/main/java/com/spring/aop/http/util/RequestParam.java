package com.spring.aop.http.util;

import com.spring.aop.http.bo.BasicHttpRequestBo;

public class RequestParam {

    private String id;
    private String name;
    private BasicHttpRequestBo requestBo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasicHttpRequestBo getRequestBo() {
        return requestBo;
    }

    public void setRequestBo(BasicHttpRequestBo requestBo) {
        this.requestBo = requestBo;
    }
}
