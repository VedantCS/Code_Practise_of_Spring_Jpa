package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Guardian;
import com.VedantCS.spring_data_jpa_practise.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
/*
some theory because I8 don't know lombok:

@Builder in Lombok:
Generates a builder class automatically
Makes object creation clean
Avoids long constructors
Very useful for Entities, DTOs, and Models
ADVANTAGES---->
Readable, No need for many constructors
Order of fields doesn't matter, Optional fields are easy
*/

class StudentRepositoryTest {
    @Autowired
private StudentRepository studentRepository;
@Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ved@gmail.com")
                .firstName("veda")
                .lastName("awte")
                //.guardianName("sudhir")
               // .guardianMobile("145744444")
                //.guardianEmail("temp@gmail. com")
                .build();
        studentRepository.save(student);
    }
 @Test
public void saveStudentWithGuardian(){
        //Lombok creates a GuardianBuilder class internally.
        Guardian guardian = Guardian.builder()
                .email("niks@gmail.com")
                .name("Nikhil")
                .mobile("123456789")

                .build();
      Student student=Student.builder()
              .firstName("shiv")
              .emailId("hi@gmail.com")
              .lastName("kumar")
              .guardian(guardian)
              .build();
      studentRepository.save(student);
}
    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            System.out.println(student);

        }
    }
    @Test
    public void PrintStudentByFirstName(){
    List<Student> students = studentRepository.findByFirstName("Veda");
    for (Student student : students) {
        System.out.println(student);
    }
    }
    @Test
    public void PrintStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("eda");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
public void printStudentBasedOnGuardianName()
{
    List<Student> students = studentRepository.findByGuardianName("Nikhil");
    System.out.println("students ="+ students);
}
@Test
    public void printgetStudentByEmailAddress()
{
        Student student=studentRepository.getStudentByEmailAddress("hi@gmail.com");
    System.out.println("student ="+student);

}
}