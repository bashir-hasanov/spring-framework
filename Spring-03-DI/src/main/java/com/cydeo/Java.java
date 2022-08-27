package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor // -> everything is done in the background, no need to type @Autowired annotation
public class Java {

    //@Autowired - Field Injection (not recommended)
    //OfficeHours officeHours;

    OfficeHours officeHours;

//    @Autowired // -> most recommended way
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: " + (20 + officeHours.getHours()));
    }
}
