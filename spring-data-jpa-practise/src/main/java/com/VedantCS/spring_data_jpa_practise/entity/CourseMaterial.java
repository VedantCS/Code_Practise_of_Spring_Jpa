package com.VedantCS.spring_data_jpa_practise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name="course_material_sequence",
            sequenceName="course_material_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL,
    fetch=FetchType.EAGER,
            optional = false

            )
    /*The optional attribute in @OneToOne (and @ManyToOne) defines whether the relationship can be null or not.
       optional = true ( by Default) means that:
        The relationship can be null.
        The foreign key column may contain NULL.
        optional = false Meaning:
        CourseMaterial must always have a Course
        JPA will treat the relationship as NOT NULL
        If you try to save CourseMaterial without a Course, it will throw an error. */
    @JoinColumn(
            name="course_Id",
            referencedColumnName = "courseId"

    )
    private Course course;
//owning side because it has the @JoinColumn.
//JPA uses this column (course_Id) to store the foreign key in the database.

}
