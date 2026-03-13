package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Course;
import com.VedantCS.spring_data_jpa_practise.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    Course coursejpa= Course.builder()
            .title("jpa")
            .credit(5)
            .build();

    Course courseOAuth= Course.builder()
            .title("Spring Security")
            .credit(5)
            .build();
    @Test
    public void saveTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Irfan")
                .lastName("Pathan")
                //  .courses(List.of(coursejpa,courseOAuth))
                .build();

        teacherRepository.save(teacher);

    }

}