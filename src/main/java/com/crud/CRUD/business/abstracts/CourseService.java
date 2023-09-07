package com.crud.CRUD.business.abstracts;

import com.crud.CRUD.entities.Student;
import com.crud.CRUD.requests.CourseCreateRequest;
import com.crud.CRUD.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course create(CourseCreateRequest newCourseRequest);
    Course get(int courseId);
    Course update(int courseId, Course courses);
    void delete(int courseId);
    Course getByCourseName(String courseName);
    void deleteMultCourse(List<Integer> courseIds);
    List<Student> getStudentsEnrolledInCourse(int courseId);

}
