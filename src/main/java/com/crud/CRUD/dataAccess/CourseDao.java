package com.crud.CRUD.dataAccess;

import com.crud.CRUD.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Integer> {

    Course getByCourseName(String courseName);


}
