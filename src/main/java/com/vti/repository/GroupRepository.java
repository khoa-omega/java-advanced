package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

public class GroupRepository {
    public void create(Group group) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }
}
