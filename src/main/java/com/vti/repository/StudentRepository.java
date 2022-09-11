package com.vti.repository;

import com.vti.entity.Student;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {
    public List<Student> getAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Student";
            Query<Student> query = session.createQuery(hql, Student.class);
            return query.getResultList();
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
