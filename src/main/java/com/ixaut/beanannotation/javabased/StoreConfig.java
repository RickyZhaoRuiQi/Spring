package com.ixaut.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {

/*    @Value("${url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${password}")
    private  String password;

    @Bean
    public MyDriverManager myDriverManager(){
        return new MyDriverManager(url,username,password);
    }*/

    /*@Bean(name = "store",initMethod = "init",destroyMethod = "destroy")  //无名称则bean是方法名
    public Store stringStore(){
        return new StringStore();
    }*/

    @Bean(name = "store")
    @Scope(value = "prototype"/*,proxyMode = ScopedProxyMode.TARGET_CLASS*/)
    public Store stringStore(){
        return new StringStore();
    }
}
