package com.crud.CRUD.business.concretes;

import com.crud.CRUD.dataAccess.CourseDao;
import com.crud.CRUD.dataAccess.StudentDao;
import com.crud.CRUD.entities.Course;
import com.crud.CRUD.entities.Student;
import com.crud.CRUD.requests.StudentCourseEnrollmentRequest;
import com.crud.CRUD.requests.StudentCreateRequest;
import com.crud.CRUD.business.abstracts.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentManager implements StudentService {
    private StudentDao studentDao;
    private CourseDao courseDao;

    public StudentManager(StudentDao studentDao , CourseDao courseDao) {
        super();
        this.studentDao = studentDao;
        this.courseDao=courseDao;
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    @Override
    public Student create(StudentCreateRequest newStudentRequest) {
        if (Objects.isNull(newStudentRequest))
            return null;
        else {
            Student toSave = new Student();
            toSave.setName(newStudentRequest.getStudentName());
            toSave.setSurname(newStudentRequest.getSurname());
            toSave.setAge(newStudentRequest.getAge());
            return studentDao.save(toSave);
        }
    }

    @Override
    public Student get(int studentId) {
        return studentDao.findById(studentId).orElse(null);
    }

    @Override
    public Student update(int studentId, Student newStudent) {
        Optional<Student> student = studentDao.findById(studentId);
        if (student.isPresent()) {
            Student foundStudent = student.get();
            foundStudent.setName(newStudent.getName());
            foundStudent.setSurname(newStudent.getSurname());
            foundStudent.setAge(newStudent.getAge());
            studentDao.save(foundStudent);
            return foundStudent;
        } else
            return null;
    }

    @Override
    public void delete(int studentId) {
        studentDao.deleteById(studentId);
    }

    @Override
    public Student getByStudentName(String studentName) {
        return studentDao.getByStudentName(studentName);
    }

    @Override
    public void deleteMultStudent(List<Integer> studentIds) {
        List<Student> studentsToDelete = studentDao.findAllById(studentIds);
        studentDao.deleteAllInBatch(studentsToDelete);
    }
    @Override
    public void enrollStudentInCourse(StudentCourseEnrollmentRequest enrollmentRequest) {
        Student student = studentDao.findById(enrollmentRequest.getStudentId()).orElse(null);
        Course course = courseDao.findById(enrollmentRequest.getCourseId()).orElse(null);

        if (student != null && course != null) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            studentDao.save(student);
        }
    }
    }


