package com.ixaut.test.aop;

import com.ixaut.aop.schema.advice.Fit;
import com.ixaut.aop.schema.advice.biz.AspectBiz;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPSchemaAdvice extends UnitTestBase {

    public TestAOPSchemaAdvice(){
        super("spring-aop-schema-advice.xml");
    }

    @Test
    public void testBiz(){
        AspectBiz biz = super.getBean("aspectBiz");
        biz.biz();
    }

    @Test
    public void testInit(){
        AspectBiz biz = super.getBean("aspectBiz");
        biz.init("moocService",3);
    }

    @Test
    public void testFit(){
        Fit fit = super.getBean("aspectBiz");
        fit.filter();
    }
}
