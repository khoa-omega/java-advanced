package com.vti.repository;

import com.vti.entity.GroupStudent;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

public class GroupStudentRepository {
    public void create(GroupStudent groupStudent) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(groupStudent);
            session.getTransaction().commit();
        }
    }
}
