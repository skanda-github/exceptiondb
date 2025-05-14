package com.example.exceptiondb.service;

import com.example.exceptiondb.entity.Student;
import com.example.exceptiondb.exception.StudentNotFoundException;
import com.example.exceptiondb.repository.StudentRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Cannot delete. Student not found with ID " + id);
        }
        repository.deleteById(id);
    }
}
