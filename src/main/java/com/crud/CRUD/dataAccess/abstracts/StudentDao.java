package com.crud.CRUD.dataAccess.abstracts;

import com.crud.CRUD.entities.concretes.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
    Student getByStudentName(String studentName);


}
