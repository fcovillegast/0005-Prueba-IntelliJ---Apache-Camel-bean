package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Page<Student>> findAll(Pageable pagina) {
        Page<Student> pageFounded = studentService.findAll(pagina);
        return new ResponseEntity<Page<Student>>(pageFounded, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<List<Student>>(studentService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student studentSaved = studentService.create(student);
        return new ResponseEntity<Student>(studentSaved , HttpStatus.CREATED);

    }
}
