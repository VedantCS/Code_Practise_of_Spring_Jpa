package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Course;
import com.VedantCS.spring_data_jpa_practise.entity.Student;
import com.VedantCS.spring_data_jpa_practise.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
private  CourseRepository courseRepository;
@Test
public void printCourses()
{
    List<Course> courses=courseRepository.
            findAll();
    System.out.println("courses are: " +courses);

}
@Test
public void saveCourseWithTeacher()
{   Teacher teacher=Teacher.builder()
        .firstName("Tarini")
        .lastName("Kumar")
        .build();

    Course course= Course.builder()
            .title("Assembly")
            .credit(5)
            .teacher(teacher)
            .build();

    courseRepository.save(course);
}

@Test
    public void findAllPagination()
    {
        Pageable firstPageWithThreeRecords=
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords=
                PageRequest.of(1, 2);

        List<Course> courses=
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        long totalElements=
                courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalElements();
        long totalPages=
                courseRepository.findAll(firstPageWithThreeRecords)
                                .getTotalPages();

        System.out.println("total elements is: " + totalElements);
        System.out.println("total pages is: " + totalPages);
        System.out.println("courses are: " +courses);

    }

    @Test
    public void findAllWithSorting()
    {
        Pageable sortByTitle=
        PageRequest.of(0, 3,
        Sort.by("title").descending()
                .and(Sort.by("credit"))
        );
    List<Course>courses=
            courseRepository.findAll(sortByTitle)
                    .getContent();

    }
    @Test
    public void saveCourseWithStudentAndTeacher()
    {
            Teacher teacher=Teacher.builder()
                    .firstName("June")
                    .lastName("Babu")
                    .build();

            Student student=Student.builder()
                    .firstName("arthur")
                    .lastName("morgan")
                    .emailId("rockstar@gmail.com")
                    .build();

          Course course=Course.builder()
                  .title("AI & Ml")
                  .credit(6)
                  .teacher(teacher)
                  .build();

        course.addStudent(student);
        courseRepository.save(course);

    }

}