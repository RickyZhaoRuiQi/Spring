package com.ixaut.test.beanannotation;

import com.ixaut.beanannotation.BeanAnnotation;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanAnnotation extends UnitTestBase {

    public TestBeanAnnotation(){
        super("spring-beanannotation.xml");
    }

    @Test
    public void say(){
        BeanAnnotation bean = super.getBean("beanAnnotation");
        bean.say("This is test.");
    }

    @Test
    public void TestScope(){
        BeanAnnotation bean1 = super.getBean("beanAnnotation");
        bean1.myHashCode();

        BeanAnnotation bean2 = super.getBean("beanAnnotation");
        bean2.myHashCode();
    }
}
