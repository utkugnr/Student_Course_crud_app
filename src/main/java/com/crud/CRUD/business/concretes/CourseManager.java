package com.crud.CRUD.business.concretes;

import com.crud.CRUD.business.abstracts.CourseService;
import com.crud.CRUD.dataAccess.abstracts.CourseDao;
import com.crud.CRUD.dataAccess.abstracts.StudentDao;
import com.crud.CRUD.entities.concretes.Course;
import com.crud.CRUD.entities.concretes.Student;
import com.crud.CRUD.requests.CourseCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseManager implements CourseService {
    private CourseDao courseDao;
    private StudentDao studentDao;


    public CourseManager(CourseDao courseDao , StudentDao studentDao){
        super();
        this.courseDao=courseDao;
        this.studentDao=studentDao;
    }

    @Override
    public List<Course> getAll() {
        return courseDao.findAll();
    }
    @Override
    public Course create(CourseCreateRequest newCourseRequest) {
        if (Objects.isNull(newCourseRequest))
           return null;
       else {
           Course toSave = new Course();
           toSave.setName(newCourseRequest.getCourseName());
           toSave.setCredit(newCourseRequest.getCredit());
           return courseDao.save(toSave);
       }
    }
    @Override
    public Course get(int courseId) {
        return courseDao.findById(courseId).orElse(null);
    }
    @Override
    public Course update(int courseId, Course newCourse) {
        Optional<Course> course = courseDao.findById(courseId);
        if (course.isPresent()) {
            Course foundCourse = course.get();
            foundCourse.setName(newCourse.getName());
            foundCourse.setCredit(newCourse.getCredit());
            courseDao.save(foundCourse);
            return foundCourse;
        }else
            return null;
    }
    @Override
    public void delete(int courseId) {
        courseDao.deleteById(courseId);
    }

    @Override
    public Course getByCourseName(String courseName) {
        return courseDao.getByCourseName(courseName);
    }

    @Override
    public void deleteMultCourse(List<Integer> courseIds) {
        List<Course> coursesToDelete = courseDao.findAllById(courseIds);
        courseDao.deleteAllInBatch(coursesToDelete);
    }

    @Override
    public List<Student> getStudentsEnrolledInCourse(int courseId) {
        Course course = courseDao.findById(courseId).orElse(null);
        return new ArrayList<>(course.getStudents());
    }


}
