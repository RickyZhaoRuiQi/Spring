package com.ixaut.test.beanannotation;

import com.ixaut.beanannotation.javabased.MyDriverManager;
import com.ixaut.beanannotation.javabased.Store;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJavabased extends UnitTestBase {

    public  TestJavabased(){
        super("spring-beanannotation.xml");
    }

    @Test
    public void test(){
        Store store = super.getBean("store");
        System.out.println(store.getClass().getName());
    }

    @Test
    public void testMyDriverManager(){
        MyDriverManager manager = super.getBean("myDriverManager");
        System.out.println(manager.getClass().getName());
    }

    @Test
    public void testScope(){
        Store store1 = super.getBean("store");
        System.out.println(store1.hashCode());

        Store store2 = super.getBean("store");
        System.out.println(store2.hashCode());
    }
}
