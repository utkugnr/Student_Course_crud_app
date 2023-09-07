package com.crud.CRUD.dataAccess;

import com.crud.CRUD.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
    Student getByStudentName(String studentName);


}
