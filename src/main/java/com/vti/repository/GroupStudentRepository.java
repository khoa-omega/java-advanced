package com.vti.repository;

import com.vti.entity.GroupStudent;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class GroupStudentRepository {
    public List<GroupStudent> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM GroupStudent", GroupStudent.class)
                    .getResultList();
        }
    }

    public void create(GroupStudent groupStudent) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(groupStudent);
            session.getTransaction().commit();
        }
    }

    public void update(GroupStudent groupStudent) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(groupStudent);
            session.getTransaction().commit();
        }
    }
}
