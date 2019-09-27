package com.example.demo.services;

import com.example.demo.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    Page<Student> findAll(Pageable page);

    List<Student> findAll();

    Student findBy(int idStudent);

    Student create(Student student);

    Student update(Student student);

    boolean delete(int idStudent);

    boolean existById(int idStudent);

}
