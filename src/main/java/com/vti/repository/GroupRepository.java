package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    public List<Group> getAll() {
        try (Session session = HibernateUtils.openSession()) {
            String hql = "FROM Group";
            Query<Group> query = session.createQuery(hql, Group.class);
            return query.getResultList();
        }
    }

    public Group getById(int id) {
        try (Session session = HibernateUtils.openSession()) {
            return session.get(Group.class, id);
        }
    }

    public void create(Group group) {
        try (Session session = HibernateUtils.openSession()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }
}
