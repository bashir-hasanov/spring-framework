package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        // left side Interface, right side Implementation -> what kind of configuration
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();

        PartTimeMentor pt = container.getBean(PartTimeMentor.class);
        pt.createAccount();

        String readStr = container.getBean(String.class);
        System.out.println(readStr);

        Integer readNumber = container.getBean(Integer.class);
        System.out.println(readNumber);
    }
}
