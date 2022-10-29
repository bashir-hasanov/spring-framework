package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    // 1. Display all departments in the 'Furniture' department
    List<Department> findByDivision(String division);

    // 2. Display all departments in the 'Health' division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // 3. Display TOP 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String email);

}
