package com.ixaut.beanannotation.javabased;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class JsrService {

    @Resource
    private JsrDAO jsrDAO;

//    @Resource
    public void setJsrDAO(JsrDAO jsrDAO){
        this.jsrDAO = jsrDAO;
    }

    public void save(){
        jsrDAO.save();
    }

    @PostConstruct
    public void init()
    {
        System.out.println("JsrService init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JsrService destroy...");
    }
}
