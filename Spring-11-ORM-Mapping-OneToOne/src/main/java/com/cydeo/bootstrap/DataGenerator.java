package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    // DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public DataGenerator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        Department d1 = new Department("Sports", "Outdoors");
        Department d2 = new Department("Tools", "Hardware");
        Department d3 = new Department("Clothing", "Home");
        Department d4 = new Department("Phones & Tablets", "Electronics");
        Department d5 = new Department("Computers", "Electronics");


        Employee e1 = new Employee("John", "Draper", "jdraper@mail.com",
                LocalDate.of(2015, 4, 20), Gender.MALE, BigDecimal.valueOf(90000));
        Employee e2 = new Employee("Ariella", "McNee", "jdoe@mail.com",
                LocalDate.of(2018, 11, 15), Gender.FEMALE, BigDecimal.valueOf(79000));
        Employee e3 = new Employee("Sydney", "Clarence", "jdoe@mail.com",
                LocalDate.of(2020, 5, 9), Gender.MALE, BigDecimal.valueOf(98500));
        Employee e4 = new Employee("Anna", "Strauss", "astrauss@mail.com",
                LocalDate.of(2019, 9, 30), Gender.FEMALE, BigDecimal.valueOf(85000));
        Employee e5 = new Employee("Felix", "Blazer", "fblazer@mail.com",
                LocalDate.of(2012, 7, 17), Gender.MALE, BigDecimal.valueOf(112000));

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        departmentList.addAll(Arrays.asList(d1, d2, d3, d4, d5));
        employeeList.addAll(Arrays.asList(e1, e2, e3, e4, e5));

       // departmentRepository.saveAll(departmentList);
        employeeRepository.saveAll(employeeList);

    }
}
