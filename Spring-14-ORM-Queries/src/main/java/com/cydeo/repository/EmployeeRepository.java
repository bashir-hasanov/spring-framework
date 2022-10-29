package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 1. Display all from employees where email address  is ' '
    List<Employee> findByEmail(String email);

    // 2. Display all employees with first name ' ' and last name ' ',
    //also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // 3. Display all employees that first name IS NOT 'Elizabeth'
    List<Employee> findByFirstNameNot(String name);

    // 4. Display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);

    // 5. Display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // 6. Display all employees with salaries not more than ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // 7. Display all employees that have been hired between '' and '' dates
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // 8. Display all employees where salaries greater and equal '' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // 9. Display top 3 unique employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // 10. Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    //---------------------------- JPQL Practice STARTS HERE -------------------------------------
    @Query("SELECT e FROM Employee e WHERE e.email = 'zbreemo@abc.net.au'") //e is an instance of Employee class here
    EmployeeRepository getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'zbreemo@abc.net.au'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary = ?2")
    Employee getEmployeeDetail(String email, int salary);
}
