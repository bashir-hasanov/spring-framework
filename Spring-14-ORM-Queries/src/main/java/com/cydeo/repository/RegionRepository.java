package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    // 1. Display all regions in Canada
   List<Region> findByCountry(String country);     // SELECT * FROM regions WHERE country = 'Canada'

    // 2. Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    // 3. Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country);

    // 4. Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainsOrderByRegion(String country);

    // 5. Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);
}
