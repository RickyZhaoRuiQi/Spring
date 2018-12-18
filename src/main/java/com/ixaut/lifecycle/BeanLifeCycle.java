package com.ixaut.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle /*implements InitializingBean, DisposableBean*/ {

    public void defaultInit(){
        System.out.println("Bean defaultInit...");
    }

    public void defaultDestroy(){
        System.out.println("Bean defaultDestroy...");
    }

    /*@Override
    public void destroy() throws Exception {
        System.out.println("Bean destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean after...");
    }*/

    /*public void start(){
        System.out.println("Bean start...");
    }

    public void stop(){
        System.out.println("Bean stop...");
    }*/
}
