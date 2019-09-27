package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> findAll(Pageable page) {
        return this.studentRepository.findAll(page);
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findBy(int id) {
        Optional<Student> studentFounded = this.studentRepository.findById(id);
        checkExist(id, studentFounded);

        return studentFounded.get();
    }

    private void checkExist(int id , Optional<Student> studentFinded) {
        if(studentFinded == null || studentFinded.get() == null) {
            throw new StudentNotExistException("No Existe el estudiante "+id);
        }
    }

    @Override
    public Student create(Student student) {
        Assert.isTrue(student != null, "Course cant not be null");
        Assert.isTrue(student.getId() == 0, "Course id must be 0 or null");
        Assert.isTrue(!existById(student.getId()), "Already exist a course with id:"+student.getId());

        Student studentSaved = this.studentRepository.save(student);

        return studentSaved;
    }

    @Override
    public Student update(Student student) {
        Assert.isTrue(student != null, "Course cant not be null");
        Student studentFounded = findBy(student.getId());

        studentFounded.setName(student.getName());

        Student studentSaved = this.studentRepository.save(studentFounded);

        return studentSaved;
    }

    @Override
    public boolean delete(int idStudent) {

        this.studentRepository.deleteById(idStudent);
        return true;
    }

    @Override
    public boolean existById(int id) {
        Optional<Student> studentFinded = this.studentRepository.findById(id);
        return studentFinded.isPresent();
    }
}
