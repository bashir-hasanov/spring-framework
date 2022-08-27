package com.cydeo.stereotype_annotations;

import com.cydeo.bean_practice.ConfigEmployee;
import com.cydeo.bean_practice.FullTimeEmployee;
import com.cydeo.stereotype_annotations.config.ConfigCourse;
import com.cydeo.stereotype_annotations.module.DataStructure;
import com.cydeo.stereotype_annotations.module.Microservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.crypto.Data;

public class CourseApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigCourse.class, ConfigEmployee.class);

        DataStructure ds = container.getBean(DataStructure.class);
        Microservice ms = container.getBean(Microservice.class);

        ds.getTotalHours();
        ms.getTotalHours();

        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();



    }
}
