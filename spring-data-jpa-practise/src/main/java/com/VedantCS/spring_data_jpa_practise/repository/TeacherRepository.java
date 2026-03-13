package com.VedantCS.spring_data_jpa_practise.repository;

import com.VedantCS.spring_data_jpa_practise.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {


}
