package com.ixaut.beanannotation.injection.service;

import com.ixaut.beanannotation.injection.dao.InjectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionServiceImpl implements InjectionService {

    @Autowired
    private InjectionDAO injectionDAO;

    @Autowired
    public InjectionServiceImpl(){
        //System.out.println("Construct annotation");
        this.injectionDAO = injectionDAO;
    }

    //构造器注入
    public InjectionServiceImpl(InjectionDAO injectionDAO){
        this.injectionDAO = injectionDAO;
    }

    //设值注入
    @Autowired
    public void setInjectionDAO(InjectionDAO injectionDAO) {
        //System.out.println("Setter annotation");
        this.injectionDAO = injectionDAO;
    }

    public void save(String arg){
        //模拟业务操作
        System.out.println("Service接收参数：" + arg);
        arg = arg + ":" + this.hashCode();
        injectionDAO.save(arg);
    }
}
