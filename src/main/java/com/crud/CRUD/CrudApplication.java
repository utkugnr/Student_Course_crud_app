package com.crud.CRUD;

import com.crud.CRUD.business.abstracts.CourseService;
import com.crud.CRUD.business.abstracts.StudentService;
import com.crud.CRUD.business.concretes.CourseManager;
import com.crud.CRUD.business.concretes.StudentManager;
import com.crud.CRUD.dataAccess.abstracts.StudentDao;
import com.crud.CRUD.entities.concretes.Course;
import com.crud.CRUD.entities.concretes.Student;
import com.crud.CRUD.requests.CourseCreateRequest;
import com.crud.CRUD.requests.StudentCreateRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);

	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.crud.CRUD"))
				.build();
	}
}

