package com.vti.repository;

import com.vti.entity.GroupStudent;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupStudentRepository {
    public List<GroupStudent> getAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM GroupStudent";
            Query<GroupStudent> query = session.createQuery(hql, GroupStudent.class);
            return query.getResultList();
        }
    }

    public void create(GroupStudent groupStudent) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(groupStudent);
            session.getTransaction().commit();
        }
    }
}
