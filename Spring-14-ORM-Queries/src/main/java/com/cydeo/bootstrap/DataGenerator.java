package com.cydeo.bootstrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
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


    }
}
