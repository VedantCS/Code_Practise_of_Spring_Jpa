package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    //JpaRepository<Course,Long> MEANS "This repository will perform database operations for the Course entity."
    //because JpaRepository is a generic interface. Generics tell Spring Data JPA what entity the repository
    // will manage and what type its primary key is.

}
