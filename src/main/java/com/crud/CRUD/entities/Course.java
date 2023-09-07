package com.crud.CRUD.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_credit")
    private int credit;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students = new HashSet<Student>();

    public Course() {
    }
    public Course(int courseId, String courseName, int credit, Set<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + courseId +
                ", name='" + courseName + '\'' +
                ", credit=" + credit +
                ", students=" + students +
                '}';
    }

    public int getId() {
        return courseId;
    }

    public String getName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setId(int id) {
        this.courseId = id;
    }

    public void setName(String name) {
        this.courseName = name;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
