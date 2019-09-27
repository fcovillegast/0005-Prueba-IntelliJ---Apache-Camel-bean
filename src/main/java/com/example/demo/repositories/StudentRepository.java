package com.example.demo.repositories;

import com.example.demo.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

    @Override
    List<Student> findAll();
}
