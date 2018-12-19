package com.ixaut.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class MoocResource implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void resource() throws IOException {
        //Resource resource = applicationContext.getResource("classpath:config.txt");
        //Resource resource = applicationContext.getResource("file:D:\\document\\JavaCode\\Spring_stu\\src\\main\\resources\\config.txt");
        Resource resource = applicationContext.getResource("url:https://docs.oracle.com/en/java/javase/11/docs/api/");
        System.out.println(resource.getFilename());
        System.out.println(resource.contentLength());
    }
}
