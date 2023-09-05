package com.crud.CRUD.business.abstracts;

import com.crud.CRUD.entities.concretes.Student;
import com.crud.CRUD.requests.StudentCourseEnrollmentRequest;
import com.crud.CRUD.requests.StudentCreateRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student create(StudentCreateRequest newStudentRequest);
    Student get(int studentId);
    Student update(int studentId, Student newStudent);
    void delete(int studentId);
    Student getByStudentName(String studentName);
    void deleteMultStudent(List<Integer> studentIds);
    void enrollStudentInCourse(StudentCourseEnrollmentRequest enrollmentRequest);
}


