package com.ixaut.test.interfaces.ioc.interfaces;

import com.ixaut.ioc.interfaces.OneInterface;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestOneInterface extends UnitTestBase {

    public TestOneInterface() {
        super("spring-ioc.xml");
    }

    @Test
    public void testSay() {
        OneInterface oneInterface = super.getBean("oneInterface");
        System.out.println(oneInterface.say("我的输入参数"));
    }

}