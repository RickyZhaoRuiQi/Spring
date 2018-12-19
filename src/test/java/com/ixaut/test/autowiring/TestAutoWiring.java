package com.ixaut.test.autowiring;

import com.ixaut.autowiring.AutoWiringService;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoWiring extends UnitTestBase {

    public TestAutoWiring(){
        super("spring-autowiring.xml");
    }

    @Test
    public void say(){
        AutoWiringService service = super.getBean("autoWiringService");
        service.say("this is a test");
    }
}
