package com.ixaut.test.interfaces.ioc.interfaces;

import com.ixaut.ioc.injection.service.InjectionService;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestInjection extends UnitTestBase {

    public TestInjection(){
        super("spring-injection.xml");
    }

    @Test
    public void testSetter(){
        InjectionService service = super.getBean("injectionService");
        service.save("这是要保存的数据");
    }

    @Test
    public void testCon(){
        InjectionService service = super.getBean("injectionService");
        service.save("这是要保存的数据");
    }
}
