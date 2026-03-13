package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student,Long> {
   public List<Student> findByFirstName(String firstName);
   public List<Student>findByFirstNameContaining(String name);

   public List<Student> findByLastNameNotNull();
   public List<Student> findByGuardianName(String guardianName);

   //trying jpql below keeep in mind jpql works on classes not on the tables, i.e.  on the entity fields
   //jpql is Entity-based query language, used for joins and complex queries
   //| Feature          | JPQL                 | Native Query               |
   //| ---------------- | -------------------- | -------------------------- |
   //| Works on         | Entity classes       | Database tables            |
   //| Uses             | `Student`, `emailId` | `student`, `email_address` |
   //| SQL features     | Limited              | Full SQL support           |
   //| nativeQuery flag | no                ```|           yas              |


   @Query("select s from Student s where s.emailId= ?1")
   Student getStudentByEmailAddress(String emailId);

   @Query(
           value="SELECT * FROM tbl_student s where s.email_address=?1",
           nativeQuery = true
   )
   Student getStudentByEmailAddressNative(String emailId);

/*
it's good to know that u should Prefer method-name queries (findBy...) unless you need complex JPQL.
@Query("select s from Student s where s.emailId = ?1 and s.name = ?2")
Student getStudentByEmailAddressAndName(String emailId, String name);
 here
?1 → emailId
?2 → name

BUT BUT BUT... instead of this we can use query parameter
*/
@Query("select s from Student s where s.emailId = :email and s.firstName = :name")
Student findByEmailIdAndName(@Param("email") String emailId,
                             @Param("name") String name);
}
