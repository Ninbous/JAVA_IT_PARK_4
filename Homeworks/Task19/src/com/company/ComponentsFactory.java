package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ComponentsFactory {

    private static ComponentsFactory instance;
    private Properties properties;

    private ComponentsFactory(){

    }

    static {
        instance = new ComponentsFactory();
    }

    public static ComponentsFactory getInstance() {
        return instance;
    }


    public void loadProp(){
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

}
