package com.crud.CRUD.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_surname")
    private String surname;
    @Column(name = "student_age")
    private int age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="students_courses",
    joinColumns = {
            @JoinColumn(name = "student_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id")
    }
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Course> courses = new HashSet<Course>();

    public Student(){

    }
    public Student(int studentId, String studentName, String surname, int age, Set<Course> courses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.surname = surname;
        this.age = age;
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + studentName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }

    public int getId() {
        return studentId;
    }

    public String getName() {
        return studentName;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
