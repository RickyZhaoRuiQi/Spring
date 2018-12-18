package com.ixaut.test.lifecycle;

import com.ixaut.lifecycle.BeanLifeCycle;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifecycle extends UnitTestBase {

    public TestBeanLifecycle(){
        super("spring-lifecycle.xml");
    }

    @Test
    public void test1(){
        super.getBean("beanLifeCycle");
    }
}
