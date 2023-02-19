package com.vti.repository;

import com.vti.entity.Student;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class StudentRepository {
    public List<Student> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Student", Student.class)
                    .getResultList();
        }
    }

    public void create(Student student) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }
}
