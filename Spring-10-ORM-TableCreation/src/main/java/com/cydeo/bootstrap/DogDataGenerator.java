package com.cydeo.bootstrap;


import com.cydeo.entity.Dog;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DogDataGenerator implements CommandLineRunner {

    DogRepository dogRepository;

    public DogDataGenerator(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Dog d1 = new Dog("Rex", "German Shepherd", Gender.MALE, 4);
        Dog d2 = new Dog("Betsy", "Husky", Gender.FEMALE, 7);
        Dog d3 = new Dog("Teddy", "St Bernard", Gender.MALE, 2);

        dogRepository.save(d1);
        dogRepository.save(d2);
        dogRepository.save(d3);

    }
}
