package com.ixaut.test.beanannotation;

import com.ixaut.beanannotation.javabased.JsrService;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;

public class TestJsr extends UnitTestBase {

    public TestJsr(){
        super("spring-beanannotation.xml");
    }

    @Test
    public void testSave(){
        JsrService service = super.getBean("jsrService");
        service.save();
    }
}
