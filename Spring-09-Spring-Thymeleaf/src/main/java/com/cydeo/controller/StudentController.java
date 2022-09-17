package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")  //here in class level we can not replace with @GetMapping
public class StudentController {

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")  //it is used only in method level, not class level
public String register(Model model) {

        model.addAttribute("students", DataGenerator.createStudent());
    return "student/register";
}
@RequestMapping("/welcome")
public String info() {

return "student/welcome";
}
}
