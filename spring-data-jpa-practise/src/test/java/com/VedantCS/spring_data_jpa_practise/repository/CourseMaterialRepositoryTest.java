package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Course;
import com.VedantCS.spring_data_jpa_practise.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CourseMaterialRepositoryTest {
@Autowired
    private CourseMaterialRepository courseMaterialRepository;
@Test
public void SaveCourseMaterial( ){
Course course=
        Course.builder()
                .title("SpringBoot")
                .credit(5)
                .build();

         CourseMaterial courseMaterial =
            CourseMaterial.builder()
            .url("www.github.com/VedantCS")
            .course(course)
            .build();
    courseMaterialRepository.save(courseMaterial);


}
public void printAllCourseMaterials(){
    List<CourseMaterial> courseMaterials=
            courseMaterialRepository.findAll();

}
}