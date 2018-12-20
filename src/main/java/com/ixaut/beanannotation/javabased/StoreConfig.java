package com.ixaut.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
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

    /*@Bean(name = "store")
    @Scope(value = "prototype"*//*,proxyMode = ScopedProxyMode.TARGET_CLASS*//*)
    public Store stringStore(){
        return new StringStore();
    }*/

    @Autowired
    private Store<String> stringStore;
    @Autowired
    private Store<Integer> integerStore;

    @Bean
    public StringStore stringStore(){
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore(){
        return new IntegerStore();
    }

    /*@Bean(name = "stringStoreTest")
    public *//*StringStore*//*Store stringStoreTest(){
        System.out.println("stringStore:"+stringStore.getClass().getName());
        System.out.println("integerStore:"+integerStore.getClass().getName());
        return new StringStore();
    }*/
}
