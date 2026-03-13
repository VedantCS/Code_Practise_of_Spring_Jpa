package com.VedantCS.spring_data_jpa_practise.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName="course_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="course_sequence"
    )

    private Long courseId;
    private String title;
    private Integer credit;
    //This is the non-owning/inverse side.
    //we use mappedBy to tell JPA hey look, the mapping is controlled by the course field in CourseMaterial.”

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
    name="teacher_Id",
    referencedColumnName ="teacherId"
    )
    private Teacher teacher;

    //in many to many there has to be new table created so we use
    //@JoinTable annotation instead of @JoinColoumn

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name="student_course_map",
            joinColumns = @JoinColumn (
                    name="course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn (
                    name="student_ID",
                    referencedColumnName = "StudentId"

            )

    )
    private List<Student> students;
    public void  addStudent(Student student){
        if(students==null){students=new ArrayList<>();}
        students.add(student);
    }
}
