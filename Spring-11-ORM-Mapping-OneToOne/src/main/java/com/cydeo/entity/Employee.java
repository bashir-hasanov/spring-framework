package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private BigDecimal salary;

    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) -> // this annotation implements JOIN and creates a FOREIGN KEYC
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")      // this annotation renames the FOREIGN KEY
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;

    public Employee(String firstName, String lastName, String email,
                    LocalDate hireDate, Gender gender, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;

    }
}
