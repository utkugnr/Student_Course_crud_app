package com.crud.CRUD.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseEnrollmentRequest {
    private int studentId;
    private int courseId;
}
