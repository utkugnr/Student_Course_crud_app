package com.crud.CRUD.dataAccess.abstracts;

import com.crud.CRUD.entities.concretes.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Integer> {

    Course getByCourseName(String courseName);


}
