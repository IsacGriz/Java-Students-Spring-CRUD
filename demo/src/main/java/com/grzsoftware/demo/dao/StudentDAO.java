package com.grzsoftware.demo.dao;

import com.grzsoftware.demo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Long id);

    int deleteAll();
}