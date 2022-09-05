package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {    //to be able to use model methods

        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        //create some random studentId(0-1000)
        Random rand = new Random();
        int studentId = rand.nextInt(1000);
        model.addAttribute("id", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(34);
        numbers.add(26);
        numbers.add(90);
        model.addAttribute("numbers", numbers);

        return "student/welcome";
    }

}
