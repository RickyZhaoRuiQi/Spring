package com.ixaut.test.resource;

import com.ixaut.resource.MoocResource;
import com.ixaut.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.IOException;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestResource extends UnitTestBase {

    public TestResource(){
        super("spring-resource.xml");
    }

    @Test
    public void testResource(){
        MoocResource resource = super.getBean("moocResource");
        try {
            resource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
