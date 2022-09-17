package com.cydeo.model;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String batch;
    private boolean graduated;
    private String company;
}
