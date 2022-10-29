package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // 1. Find all courses by category
    List<Course> findByCategory(String category);

    // 2. Find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    // 3. Check if a course with the provided name exists, return true if yes, false otherwise
    boolean existsByName(String name);

    // 4. Return the count of courses for provided category
    int countByCategory(String category);

    // 5. Find all courses that start with provided course name
    List<Course> findByNameStartingWith(String name);

    // 6. Find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);



}
