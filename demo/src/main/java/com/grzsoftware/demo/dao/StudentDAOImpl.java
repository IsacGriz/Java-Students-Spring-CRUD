package com.grzsoftware.demo.dao;

import com.grzsoftware.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager em;

    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("select s from Student s where s.lastName = :lastName", Student.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deletedUsers = 0;

        deletedUsers = em.createQuery("delete from Student")
                .executeUpdate();

        return deletedUsers;
    }
}
