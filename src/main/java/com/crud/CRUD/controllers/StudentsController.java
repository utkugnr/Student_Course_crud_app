package com.crud.CRUD.controllers;

import com.crud.CRUD.entities.Student;
import com.crud.CRUD.requests.StudentCourseEnrollmentRequest;
import com.crud.CRUD.requests.StudentCreateRequest;
import com.crud.CRUD.business.abstracts.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentsController {
    private StudentService studentService;


    public StudentsController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll(){
       return this.studentService.getAll();
    }
    @PostMapping
    public Student create(@RequestBody StudentCreateRequest newStudentRequest){
        return this.studentService.create(newStudentRequest);
    }
    @GetMapping("/{studentId}")
    public Student get(@PathVariable int studentId){
        return this.studentService.get(studentId);
    }
    @PutMapping("/{studentId}")
    public Student update(@PathVariable int studentId, @RequestBody Student newStudent){
       return this.studentService.update(studentId,newStudent);
    }
    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable int studentId){
        studentService.delete(studentId);
    }
    @GetMapping("/byname/{studentName}")
    public Student getByStudentName(@PathVariable String studentName) {
        return this.studentService.getByStudentName(studentName);
    }
    @DeleteMapping("/deletemultstudent")
    public void deleteMultStudent(@RequestParam List<Integer> studentIds){
        this.studentService.deleteMultStudent(studentIds);
    }
    @PostMapping("/enroll")
    public void enrollStudentInCourse(@RequestBody StudentCourseEnrollmentRequest enrollmentRequest){
        this.studentService.enrollStudentInCourse(enrollmentRequest);
    }
    }



