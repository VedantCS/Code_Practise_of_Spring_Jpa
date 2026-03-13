package com.VedantCS.spring_data_jpa_practise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
        name="teacher_sequence",
        sequenceName = "teacher_sequence",
        allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="teacher_sequence"
    )
    private Long teacherId;

    private String firstName;
    private String lastName;
    /* example of one to many ->

    @OneToMany
            (
                    cascade = CascadeType.ALL

            )
    @JoinColumn
            (
                    name="teacher_Id",
                    referencedColumnName = "teacherId"

            )

    Observations: Even though the annotation is written in the Teacher class,
     the column is created in Course table.
    Intuition(think like a db)-->
    JPA needs to know:
What column holds the relationship?
That is exactly what @JoinColumn tells JPA.
name="teacher_Id" means create a column called teacher_Id in 'Course' table
and it references Teacher.teacherId by referencedColumnName="teacherId"
  so sql equivalent is teacher_Id FOREIGN KEY REFERENCES Teacher(teacherId)
Just in case I forgot or get confused in future:
Without @JoinColumn, Hibernate would create a third table
Think of @JoinColumn as: Which column stores the foreign key?
Also, here is how hibernate/JPA/ORM converts our java code into sql:
1> Hibernate scans the classpath and detects classes annotated with @Entity.

2> Each @Entity becomes a database table (e.g., Teacher → teacher).

3> Fields in the class become table columns using Hibernate’s naming strategy (firstName → first_name).

4> @Id marks the primary key column in the table.

5> @SequenceGenerator + @GeneratedValue create a database sequence (teacher_sequence) for auto-generating IDs.

6> Hibernate processes relationships like @OneToMany to understand entity associations.

7> @JoinColumn tells Hibernate where to store the foreign key (here teacher_id in the course table).

8️> Hibernate generates the second table (course) and adds the teacher_id column.

9> A foreign key constraint is created linking course.teacher_id → teacher.teacher_id.

10> When saving data, Hibernate generates SQL to insert Teacher first, then Courses with the teacher’s foreign key

    private List<Course> courses;
*/

}
