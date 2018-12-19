package com.ixaut.autowiring;

public class AutoWiringService {

    private AutoWiringDAO autoWiringDAO;

    public AutoWiringService(AutoWiringDAO autoWiringDAO){
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String word){
        this.autoWiringDAO.say(word);
    }
}
