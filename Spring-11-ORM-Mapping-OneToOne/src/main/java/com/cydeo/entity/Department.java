package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity {

    private String department;
    private String division;

    @OneToOne(mappedBy = "department")  //this field gives ownership to Employee
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }

}
