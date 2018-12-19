package com.ixaut.test.beanannotation;

import com.ixaut.beanannotation.injection.service.InjectionService;
import com.ixaut.beanannotation.multibean.BeanInvoker;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {

    public TestInjection(){
        super("spring-beanannotation.xml");
    }

    @Test
    public void testAutowired(){
        InjectionService service = super.getBean("injectionServiceImpl");
        service.save("This is autowired.");
    }

    @Test
    public void testMultiBean(){
        BeanInvoker invoker = getBean("beanInvoker");
        invoker.say();
    }
}
