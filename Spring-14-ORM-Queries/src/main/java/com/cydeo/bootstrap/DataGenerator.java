package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("------------------ REGION START -------------------");

        System.out.println("Find by country: - " + regionRepository.findByCountry("Canada"));

        System.out.println("Find unique by country: - " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("Find country containing 'United' - " + regionRepository.findByCountryContaining("United"));

        System.out.println("FindByCountryContainsOrderByRegion - " + regionRepository.findByCountryContainsOrderByRegion("United"));

        System.out.println("FindTopByCountry - " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("------------------ REGION END -------------------");

        System.out.println("------------------ DEPARTMENT START -------------------");

        System.out.println("FindByDivision - " + departmentRepository.findByDivision("Entertainment"));

        System.out.println("FindByDivisionIs - " + departmentRepository.findByDivisionIs("Health"));

        System.out.println("findTop3DistinctByDivisionContains - " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("------------------ DEPARTMENT END -------------------");

        System.out.println("------------------ EMPLOYEE START -------------------");

        System.out.println("findByEmail - " + employeeRepository.findByEmail("mhuggard4w@php.net"));

        System.out.println("findByFirstNameNot - " + employeeRepository.findByFirstNameNot("Elizabeth"));



        System.out.println("------------------ EMPLOYEE END -------------------");


    }
}
