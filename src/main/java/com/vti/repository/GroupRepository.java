package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class GroupRepository {
    public List<Group> findAll() {
        try (Session session = HibernateUtils.openSession()) {
            return session
                    .createQuery("FROM Group", Group.class)
                    .getResultList();
        }
    }

    public void create(Group group) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }

    public void update(Group group) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.merge(group);
            session.getTransaction().commit();
        }
    }
}
