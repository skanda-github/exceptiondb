package com.example.exceptiondb.repository;

import org.springframework.stereotype.Repository;
import com.example.exceptiondb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
