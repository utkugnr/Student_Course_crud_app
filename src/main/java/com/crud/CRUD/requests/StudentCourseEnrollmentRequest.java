package com.crud.CRUD.requests;

import lombok.Data;

@Data
public class StudentCourseEnrollmentRequest {
    private int studentId;
    private int courseId;
}
