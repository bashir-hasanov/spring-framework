package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository {

    // assume we are getting info from DB
    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Mike", "IT", 55);

        return employee.getHourlyRate();
    }
}
