package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext (ConfigEmployee.class);

        FullTimeEmployee ftEmp = container.getBean(FullTimeEmployee.class);
        PartTimeEmployee ptEmp = container.getBean(PartTimeEmployee.class);

        ftEmp.createAccount();
        ptEmp.createAccount();
    }
}
