package com.ixaut.ioc.interfaces;

public class OneInterfaceImpl implements OneInterface {
    @Override
    public String say(String word) {
        return "Word form interface \"OneInterface\":" + word;
    }
}
