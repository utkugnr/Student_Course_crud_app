package com.crud.CRUD.requests;

import lombok.Data;

@Data
public class StudentCreateRequest {

    String studentName;
    String surname;
    int age;

}
